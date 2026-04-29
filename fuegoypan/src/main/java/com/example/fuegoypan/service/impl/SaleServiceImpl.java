package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.dto.*;
import com.example.fuegoypan.model.*;
import com.example.fuegoypan.repository.*;
import com.example.fuegoypan.service.SaleService;
import com.example.fuegoypan.service.StockMovementService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepo saleRepo;
    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final RecipeRepo recipeRepo;
    private final StockIngredientRepo stockRepo;
    private final StockMovementService stockMovementService;

    public SaleServiceImpl(
            SaleRepo saleRepo,
            ProductRepo productRepo,
            UserRepo userRepo,
            RecipeRepo recipeRepo,
            StockIngredientRepo stockRepo,
            StockMovementService stockMovementService
    ) {
        this.saleRepo = saleRepo;
        this.productRepo = productRepo;
        this.userRepo = userRepo;
        this.recipeRepo = recipeRepo;
        this.stockRepo = stockRepo;
        this.stockMovementService = stockMovementService;
    }

    @Transactional
    @Override
    public SaleDTO createSale(SaleCreateDTO dto, Authentication auth) {

        String username = auth.getName();

        User user = userRepo.findByName(username)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        Sale sale = new Sale();
        sale.setUser(user);
        sale.setStatus(dto.getStatus() != null ? dto.getStatus() : SaleStatus.OPEN);

        List<SaleLine> lines = new ArrayList<>();

        for (SaleLineCreateDTO lineDTO : dto.getLines()) {

            Product product = productRepo.findById(lineDTO.getProductId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Producto no encontrado"));

            SaleLine line = new SaleLine();
            line.setProduct(product);
            line.setQuantity(lineDTO.getQuantity());
            line.setUnitPrice(product.getPrice());

            //  SOLO VALIDACIÓN (NO DESCUENTA STOCK)
            if (product.getRecipeItems() != null) {

                product.getRecipeItems().forEach(recipe -> {

                    StockIngredient stock = stockRepo.findById(
                            recipe.getIngredient().getId()
                    ).orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Stock del ingrediente no encontrado"));

                    double needed = recipe.getQuantity() * lineDTO.getQuantity();

                    if (stock.getCurrentStock() < needed) {
                        throw new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Stock insuficiente para: " + recipe.getIngredient().getName()
                        );
                    }
                });
            }

            line.setSale(sale);
            lines.add(line);
        }

        sale.setLines(lines);

        double total = lines.stream()
                .mapToDouble(l -> l.getQuantity() * l.getUnitPrice())
                .sum();

        sale.setTotal(total);

        Sale saved = saleRepo.save(sale);

        return mapToDTO(saved);
    }


    // UPDATE STATUS, AQUÍ SE DESCUENTA
    @Transactional
    @Override
    public SaleDTO updateStatus(Long id, String status) {

        Sale sale = saleRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Venta no encontrada"));

        SaleStatus oldStatus = sale.getStatus();
        SaleStatus newStatus = SaleStatus.valueOf(status);

        sale.setStatus(newStatus);

        Sale saved = saleRepo.save(sale);


        if (oldStatus != SaleStatus.PAID && newStatus == SaleStatus.PAID) {
            stockMovementService.registerSaleConsumption(saved.getId());
        }

        return mapToDTO(saved);
    }

    @Transactional
    @Override
    public SaleDTO cancelSale(Long id) {

        Sale sale = saleRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Venta no encontrada"));

        if (sale.getStatus() == SaleStatus.CANCELLED) {
            return mapToDTO(sale);
        }

        sale.setStatus(SaleStatus.CANCELLED);

        return mapToDTO(saleRepo.save(sale));
    }


    @Override
    public List<SaleDTO> getAll() {
        return saleRepo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SaleDTO getById(Long id) {
        return saleRepo.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Venta no encontrada"));
    }


    private SaleDTO mapToDTO(Sale sale) {

        SaleDTO dto = new SaleDTO();
        dto.setId(sale.getId());
        dto.setDate(sale.getDate());
        dto.setTotal(sale.getTotal());
        dto.setStatus(sale.getStatus());
        dto.setUserId(sale.getUser().getId());

        dto.setLines(sale.getLines().stream().map(line -> {
            SaleLineDTO lineDTO = new SaleLineDTO();
            lineDTO.setId(line.getId());
            lineDTO.setProductId(line.getProduct().getId());
            lineDTO.setQuantity(line.getQuantity());
            lineDTO.setUnitPrice(line.getUnitPrice());
            return lineDTO;
        }).collect(Collectors.toList()));

        return dto;
    }
}