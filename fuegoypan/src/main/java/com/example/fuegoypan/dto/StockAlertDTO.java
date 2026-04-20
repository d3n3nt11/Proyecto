package com.example.fuegoypan.dto;


public class StockAlertDTO {

    private final String ingredientName;
    private final double currentStock;
    private final double minStock;

    public StockAlertDTO(String ingredientName, double currentStock, double minStock) {
        this.ingredientName = ingredientName;
        this.currentStock = currentStock;
        this.minStock = minStock;
    }

    public String getIngredientName() { return ingredientName; }
    public double getCurrentStock() { return currentStock; }
    public double getMinStock() { return minStock; }
}