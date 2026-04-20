package com.example.fuegoypan.dto;

import com.example.fuegoypan.model.MovementType;

public class StockMovementDTO {

    private Long ingredientId;
    private Double quantity;
    private MovementType type;
    private Long saleId;

    // getters/setters


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