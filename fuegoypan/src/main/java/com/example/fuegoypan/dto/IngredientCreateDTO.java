package com.example.fuegoypan.dto;

import lombok.Data;

public class IngredientCreateDTO {

    private String name;
    private String unit;
    private String image;

    public IngredientCreateDTO() {
    }

    public IngredientCreateDTO(String unit, String name, String image) {
        this.unit = unit;
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}