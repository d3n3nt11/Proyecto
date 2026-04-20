package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.dto.StockMovementDTO;
import com.example.fuegoypan.model.*;
import com.example.fuegoypan.repository.*;
import com.example.fuegoypan.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockMovementServiceImpl implements StockMovementService {

    private final StockMovementRepo stockMovementRepo;
    private final IngredientRepo ingredientRepo;
    private final SaleRepo saleRepo;
    private final RecipeRepo recipeRepo;
    private final StockIngredientRepo stockIngredientRepo;

    @Override
    public void createMovement(StockMovementDTO dto) {

        Ingredient ingredient = ingredientRepo.findById(dto.getIngredientId())
                .orElseThrow();

        StockMovement movement = new StockMovement();
        movement.setIngredient(ingredient);
        movement.setQuantity(dto.getQuantity());
        movement.setType(dto.getType());
        movement.setCreatedAt(LocalDateTime.now());

        if (dto.getSaleId() != null) {
            Sale sale = saleRepo.findById(dto.getSaleId()).orElseThrow();
            movement.setSale(sale);
        }

        stockMovementRepo.save(movement);

        // actualizar stock actual
        StockIngredient stock = stockIngredientRepo
                .findByIngredient_Id(ingredient.getId())
                .orElseThrow();

        stock.setCurrentStock(stock.getCurrentStock() + dto.getQuantity());

        stockIngredientRepo.save(stock);
    }

    @Override
    public void registerSaleConsumption(Long saleId) {

        Sale sale = saleRepo.findById(saleId).orElseThrow();

        for (SaleLine line : sale.getLines()) {

            Long productId = line.getProduct().getId();
            int quantitySold = line.getQuantity();

            // obtener receta del producto
            List<Recipe> recipes = recipeRepo.findByProductId(productId);

            for (Recipe recipe : recipes) {

                double totalConsumption = recipe.getQuantity() * quantitySold;

                StockMovementDTO dto = new StockMovementDTO();
                dto.setIngredientId(recipe.getIngredient().getId());
                dto.setQuantity(-totalConsumption); //  negativo = consumo
                dto.setType(MovementType.SALE);
                dto.setSaleId(saleId);

                createMovement(dto);
            }
        }
    }
}