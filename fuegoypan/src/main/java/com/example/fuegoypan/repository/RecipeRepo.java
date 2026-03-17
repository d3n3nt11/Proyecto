package com.example.fuegoypan.repository;

import com.example.fuegoypan.model.Recipe;
import com.example.fuegoypan.model.RecipeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, RecipeId> {
}