package com.example.fuegoypan.dto;


public class IngredientDTO {

    private Long id;
    private String name;
    private String unit;

    public IngredientDTO(Long id, String unit, String name) {
        this.id = id;
        this.unit = unit;
        this.name = name;
    }

    public IngredientDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}