package com.example.fuegoypan.dto;


import com.example.fuegoypan.model.Category;

public class ProductCreateDTO {

    private String name;
    private Double price;
    private String description;
    private Boolean visible;
    private Category category;
    private String imageUrl;

    public ProductCreateDTO() {}

    public ProductCreateDTO(String name, Double price, String description, Boolean visible, Category category, String imageUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.visible = visible;
        this.category = category;
        this.imageUrl = imageUrl;
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