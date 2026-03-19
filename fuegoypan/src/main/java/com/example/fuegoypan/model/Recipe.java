package com.example.fuegoypan.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipe")
public class Recipe {
    @EmbeddedId
    private RecipeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(nullable = false)
    private Double quantity;

    public Recipe() {
    }

    public Recipe(Product product, Ingredient ingredient, Double quantity) {
        this.product = product;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.id = new RecipeId(product.getId(), ingredient.getId());
    }

    public RecipeId getId() {
        return id;
    }

    public void setId(RecipeId id) {
        this.id = id;
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