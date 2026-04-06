package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.dto.*;
import com.example.fuegoypan.model.*;
import com.example.fuegoypan.repository.*;
import com.example.fuegoypan.service.SaleService;
import org.springframework.http.HttpStatus;
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

    public SaleServiceImpl(SaleRepo saleRepo,
                           ProductRepo productRepo,
                           UserRepo userRepo,
                           RecipeRepo recipeRepo,
                           StockIngredientRepo stockRepo) {
        this.saleRepo = saleRepo;
        this.productRepo = productRepo;
        this.userRepo = userRepo;
        this.recipeRepo = recipeRepo;
        this.stockRepo = stockRepo;
    }

    @Transactional
    @Override
    public SaleDTO createSale(SaleCreateDTO dto) {

        //  Validar usuario
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        //  Crear venta
        Sale sale = new Sale();
        sale.setUser(user);
        sale.setStatus(dto.getStatus());

        List<SaleLine> lines = new ArrayList<>();

        //  Procesar líneas
        for (SaleLineCreateDTO lineDTO : dto.getLines()) {

            Product product = productRepo.findById(lineDTO.getProductId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Producto no encontrado"));

            SaleLine line = new SaleLine();
            line.setProduct(product);
            line.setQuantity(lineDTO.getQuantity());
            line.setUnitPrice(product.getPrice());

            //  Validar y descontar stock
            if (product.getRecipeItems() != null) {

                product.getRecipeItems().forEach(recipe -> {

                    StockIngredient stock = stockRepo.findById(recipe.getIngredient().getId())
                            .orElseThrow(() -> new ResponseStatusException(
                                    HttpStatus.NOT_FOUND, "Stock del ingrediente no encontrado"));

                    double used = recipe.getQuantity() * lineDTO.getQuantity();

                    //  VALIDACIÓN CRÍTICA
                    if (stock.getCurrentStock() < used) {
                        throw new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Stock insuficiente para: " + recipe.getIngredient().getName()
                        );
                    }

                    stock.setCurrentStock(stock.getCurrentStock() - used);
                    stockRepo.save(stock);
                });
            }

            //  Relación bidireccional
            line.setSale(sale);
            lines.add(line);
        }

        sale.setLines(lines);

        //  Calcular total
        double total = lines.stream()
                .mapToDouble(l -> l.getQuantity() * l.getUnitPrice())
                .sum();

        sale.setTotal(total);

        //  Guardar
        Sale saved = saleRepo.save(sale);

        return mapToDTO(saved);
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

    @Transactional
    @Override
    public SaleDTO updateStatus(Long id, String status) {
        Sale sale = saleRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Venta no encontrada"));

        sale.setStatus(SaleStatus.valueOf(status));

        return mapToDTO(saleRepo.save(sale));
    }

    @Transactional
    @Override
    public SaleDTO cancelSale(Long id) {
        Sale sale = saleRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Venta no encontrada"));

        if ("CANCELLED".equals(sale.getStatus())) {
            return mapToDTO(sale);
        }

        //  DEVOLVER STOCK
        for (SaleLine line : sale.getLines()) {

            Product product = line.getProduct();

            if (product.getRecipeItems() != null) {

                product.getRecipeItems().forEach(recipe -> {

                    StockIngredient stock = stockRepo.findById(
                            recipe.getIngredient().getId()
                    ).orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Stock no encontrado"));

                    double used = recipe.getQuantity() * line.getQuantity();

                    stock.setCurrentStock(stock.getCurrentStock() + used);
                    stockRepo.save(stock);
                });
            }
        }

        sale.setStatus(SaleStatus.valueOf("CANCELLED"));

        return mapToDTO(saleRepo.save(sale));
    }

    //  Mapeo a DTO
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