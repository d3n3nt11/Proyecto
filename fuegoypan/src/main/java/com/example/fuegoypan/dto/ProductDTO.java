package com.example.fuegoypan.dto;

public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private Boolean visible;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, Boolean visible) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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
}