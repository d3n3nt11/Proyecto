package com.example.fuegoypan.dto;

import lombok.Data;

@Data
public class RecipeCreateDTO {

    private Long productId;
    private Long ingredientId;
    private Double quantity;

}