package com.example.fuegoypan.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StockIngredientDTO {

    private Long ingredientId;
    private String ingredientName;
    private Double maxStock;
    private Double minStock;
    private LocalDate expirationDate;
}