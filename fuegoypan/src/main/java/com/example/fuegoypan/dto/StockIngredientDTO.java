package com.example.fuegoypan.dto;


import java.time.LocalDate;


public class StockIngredientDTO {

    private Long ingredientId;
    private String ingredientName;
    private Double currentStock;
    private Double minStock;
    private LocalDate expirationDate;
    private String unit;
    private String image;

    public StockIngredientDTO() {
    }

    public StockIngredientDTO(Long ingredientId, Double maxStock, String ingredientName, Double minStock, LocalDate expirationDate,String unit, String image) {
        this.ingredientId = ingredientId;
        this.currentStock = maxStock;
        this.ingredientName = ingredientName;
        this.minStock = minStock;
        this.expirationDate = expirationDate;
        this.unit = unit;
        this.image = image;
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