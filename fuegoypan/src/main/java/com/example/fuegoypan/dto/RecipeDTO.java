package com.example.fuegoypan.dto;

import lombok.Data;

@Data
public class RecipeDTO {

    private Long productId;
    private Long ingredientId;
    private Double quantity;

    private String ingredientName; // opcional, útil para mostrar al frontend

}