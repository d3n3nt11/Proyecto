package com.example.fuegoypan.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "stock_ingredient")
public class StockIngredient {
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private Double currentStock;

    private Double maxStock;

    private Double minStock; //para las alertas

    private LocalDate expirationDate;

    public StockIngredient() {
    }

    public StockIngredient(Ingredient ingredient, Double currentStock, Double maxStock, Double minStock, LocalDate expirationDate) {
        this.ingredient = ingredient;
        this.currentStock = currentStock;
        this.maxStock = maxStock;
        this.minStock = minStock;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Double getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Double currentStock) {
        this.currentStock = currentStock;
    }

    public Double getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Double maxStock) {
        this.maxStock = maxStock;
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
