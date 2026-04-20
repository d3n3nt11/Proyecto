package com.example.fuegoypan.repository;

import com.example.fuegoypan.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;
import java.util.List;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {

    List<Recipe> findByProductId(Long productId);

    Optional<Recipe> findByProductIdAndIngredientId(Long productId, Long ingredientId);
}