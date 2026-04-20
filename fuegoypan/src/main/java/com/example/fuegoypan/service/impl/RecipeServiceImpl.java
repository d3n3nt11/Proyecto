package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.dto.RecipeCreateDTO;
import com.example.fuegoypan.dto.RecipeDTO;
import com.example.fuegoypan.model.*;
import com.example.fuegoypan.repository.*;
import com.example.fuegoypan.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepo recipeRepo;
    private final ProductRepo productRepo;
    private final IngredientRepo ingredientRepo;

    public RecipeServiceImpl(RecipeRepo recipeRepo,
                             ProductRepo productRepo,
                             IngredientRepo ingredientRepo) {
        this.recipeRepo = recipeRepo;
        this.productRepo = productRepo;
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public RecipeDTO addIngredientToProduct(RecipeCreateDTO dto) {

        Product product = productRepo.findById(dto.getProductId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        Ingredient ingredient = ingredientRepo.findById(dto.getIngredientId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingrediente no encontrado"));

        // comprobar si ya existe (por el unique constraint)
        Recipe existing = recipeRepo
                .findByProductIdAndIngredientId(dto.getProductId(), dto.getIngredientId())
                .orElse(null);

        if (existing != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ingrediente ya existe en la receta");
        }

        Recipe recipe = new Recipe();
        recipe.setProduct(product);
        recipe.setIngredient(ingredient);
        recipe.setQuantity(dto.getQuantity());

        Recipe saved = recipeRepo.save(recipe);

        return mapToDTO(saved);
    }

    @Override
    public RecipeDTO updateIngredientQuantity(RecipeCreateDTO dto) {

        Recipe recipe = recipeRepo
                .findByProductIdAndIngredientId(dto.getProductId(), dto.getIngredientId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receta no encontrada"));

        recipe.setQuantity(dto.getQuantity());

        Recipe saved = recipeRepo.save(recipe);

        return mapToDTO(saved);
    }

    @Override
    public void removeIngredientFromProduct(Long productId, Long ingredientId) {

        Recipe recipe = recipeRepo
                .findByProductIdAndIngredientId(productId, ingredientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receta no encontrada"));

        recipeRepo.delete(recipe);
    }

    @Override
    public List<RecipeDTO> getIngredientsByProduct(Long productId) {

        // opcional validar producto
        if (!productRepo.existsById(productId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }

        return recipeRepo.findByProductId(productId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private RecipeDTO mapToDTO(Recipe recipe) {
        RecipeDTO dto = new RecipeDTO();
        dto.setProductId(recipe.getProduct().getId());
        dto.setIngredientId(recipe.getIngredient().getId());
        dto.setQuantity(recipe.getQuantity());
        dto.setIngredientName(recipe.getIngredient().getName());
        return dto;
    }
}