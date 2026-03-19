package com.example.fuegoypan.dto;



public class ProductCreateDTO {

    private String name;
    private Double price;
    private String description;
    private Boolean visible;


    public ProductCreateDTO() {
    }

    public ProductCreateDTO(String name, Double price, String description, Boolean visible) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.visible = visible;
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