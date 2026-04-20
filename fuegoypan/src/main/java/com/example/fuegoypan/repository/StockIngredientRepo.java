package com.example.fuegoypan.repository;

import com.example.fuegoypan.dto.StockAlertDTO;
import com.example.fuegoypan.model.StockIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockIngredientRepo extends JpaRepository<StockIngredient, Long> {
    Optional<StockIngredient> findByIngredient_Id(Long ingredientId);

    @Query("""
    SELECT new com.example.fuegoypan.dto.StockAlertDTO(
        i.name,
        s.currentStock,
        s.minStock
    )
    FROM StockIngredient s
    JOIN s.ingredient i
    WHERE s.currentStock <= s.minStock
    """)
    List<StockAlertDTO> findLowStock();
}