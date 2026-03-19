package com.example.fuegoypan.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeId implements Serializable {

    private Long productId;
    private Long ingredientId;

    public RecipeId() {
    }


    public RecipeId(Long productId, Long ingredientId) {
        this.productId = productId;
        this.ingredientId = ingredientId;
    }


    public Long getProductId() {
        return productId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeId that)) return false;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(ingredientId, that.ingredientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, ingredientId);
    }
}