package com.example.fuegoypan.dto;


public class RecipeDTO {

    private Long productId;
    private Long ingredientId;
    private Double quantity;
    private String ingredientName;

    public RecipeDTO() {
    }

    public RecipeDTO(Long productId, Long ingredientId, Double quantity, String ingredientName) {
        this.productId = productId;
        this.ingredientId = ingredientId;
        this.quantity = quantity;
        this.ingredientName = ingredientName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}