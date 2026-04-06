package com.example.fuegoypan.dto;


import java.time.LocalDate;


public class StockIngredientDTO {

    private Long ingredientId;
    private String ingredientName;
    private Double currentStock;
    private Double minStock;
    private LocalDate expirationDate;

    public StockIngredientDTO() {
    }

    public StockIngredientDTO(Long ingredientId, Double maxStock, String ingredientName, Double minStock, LocalDate expirationDate) {
        this.ingredientId = ingredientId;
        this.currentStock = maxStock;
        this.ingredientName = ingredientName;
        this.minStock = minStock;
        this.expirationDate = expirationDate;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Double getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Double currentStock) {
        this.currentStock = currentStock;
    }

    public Double getMinStock() {
        return minStock;
    }

    public void setMinStock(Double minStock) {
        this.minStock = minStock;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}