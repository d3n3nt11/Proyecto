package com.example.fuegoypan.repository;

import com.example.fuegoypan.model.StockIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockIngredientRepo extends JpaRepository<StockIngredient, Long> {
}