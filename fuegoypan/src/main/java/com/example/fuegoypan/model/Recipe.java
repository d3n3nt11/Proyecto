package com.example.fuegoypan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe",
        uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "ingredient_id"}))
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(nullable = false)
    private Double quantity;

    // 🔹 Constructor vacío (obligatorio para JPA)
    public Recipe() {
    }

    // 🔹 Constructor útil
    public Recipe(Product product, Ingredient ingredient, Double quantity) {
        this.product = product;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    // 🔹 Getters y Setters

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}