package com.example.fuegoypan.dto;

import com.example.fuegoypan.model.MovementType;

public class StockMovementDTO {

    private Long ingredientId;
    private Double quantity;
    private String ingredientName;
    private String unit;
    private MovementType type;
    private Long saleId;

    public StockMovementDTO() {
    }

    public StockMovementDTO(Long ingredientId, Double quantity, MovementType type, Long saleId) {
        this.ingredientId = ingredientId;
        this.quantity = quantity;
        this.type = type;
        this.saleId = saleId;
    }

    // getters/setters


    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}