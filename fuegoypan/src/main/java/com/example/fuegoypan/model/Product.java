package com.example.fuegoypan.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private String description;

    private Boolean visible;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Recipe> recipeItems = new ArrayList<>();

    public Product() {
    }

    public Product(Long id, String name, Double price, String description, List<Recipe> recipeItems, Boolean visible) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.recipeItems = recipeItems;
        this.visible = visible;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public List<Recipe> getRecipeItems() {
        return recipeItems;
    }

    public void setRecipeItems(List<Recipe> recipeItems) {
        this.recipeItems = recipeItems;
    }
}