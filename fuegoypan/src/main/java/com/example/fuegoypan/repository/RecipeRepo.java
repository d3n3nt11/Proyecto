package com.example.fuegoypan.repository;

import com.example.fuegoypan.model.Ingredient;
import com.example.fuegoypan.model.Product;
import com.example.fuegoypan.model.Recipe;
import com.example.fuegoypan.model.RecipeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, RecipeId> {
    Optional<Recipe> findByProductAndIngredient(Product product, Ingredient ingredient);
}