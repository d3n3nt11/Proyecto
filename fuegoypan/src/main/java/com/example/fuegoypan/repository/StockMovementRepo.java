package com.example.fuegoypan.repository;

import com.example.fuegoypan.model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMovementRepo extends JpaRepository<StockMovement, Long> {

    List<StockMovement> findByIngredientId(Long ingredientId);

}