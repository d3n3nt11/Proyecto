package com.example.fuegoypan.dto;


public class RecipeCreateDTO {

    private Long productId;
    private Long ingredientId;
    private Double quantity;


    public RecipeCreateDTO() {
    }

    public RecipeCreateDTO(Long productId, Long ingredientId, Double quantity) {
        this.productId = productId;
        this.ingredientId = ingredientId;
        this.quantity = quantity;
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
}