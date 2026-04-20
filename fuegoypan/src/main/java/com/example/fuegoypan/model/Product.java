package com.example.fuegoypan.model;

import jakarta.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private Category category;

    private String imageUrl;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Recipe> recipeItems = new ArrayList<>();

    public Product() {
    }

    public Product(Long id, String name, Double price, String description, Boolean visible, Category category, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.visible = visible;
        this.category = category;
        this.imageUrl = imageUrl;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}