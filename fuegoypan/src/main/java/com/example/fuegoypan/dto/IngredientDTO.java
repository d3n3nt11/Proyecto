package com.example.fuegoypan.dto;

import lombok.Data;

@Data
public class IngredientDTO {

    private Long id;
    private String name;
    private String unit; // ej: kg, g, litros, unidades

}