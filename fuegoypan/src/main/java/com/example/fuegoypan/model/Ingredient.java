package com.example.fuegoypan.model;

import jakarta.persistence.*;


@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String unit; // kg, g, unidades, litros...

    @Column(name = "image")
    private String image;

    @OneToOne(mappedBy = "ingredient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private StockIngredient stock;

    public Ingredient(Long id, String name, String unit, StockIngredient stock) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.stock = stock;
    }
    public Ingredient() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StockIngredient getStock() {
        return stock;
    }

    public void setStock(StockIngredient stock) {
        this.stock = stock;
    }
}
