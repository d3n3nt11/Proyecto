package com.example.fuegoypan.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StockAlertDTO {
    private String ingredientName;
    private Double currentStock;
    private Double minStock;
    private String unit;
    private String expirationDate;


    public StockAlertDTO(String ingredientName, Double currentStock, Double minStock) {
        this.ingredientName = ingredientName;
        this.currentStock = currentStock;
        this.minStock = minStock;
        // unit y expirationDate quedan null automáticamente
    }


    public StockAlertDTO(String ingredientName, Double currentStock, Double minStock,
                         String unit, String expirationDate) {
        this.ingredientName = ingredientName;
        this.currentStock = currentStock;
        this.minStock = minStock;
        this.unit = unit;
        this.expirationDate = expirationDate;
    }
}