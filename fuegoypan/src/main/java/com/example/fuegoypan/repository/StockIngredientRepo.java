package com.example.fuegoypan.repository;

import com.example.fuegoypan.dto.StockAlertDTO;
import com.example.fuegoypan.model.StockIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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


    @Query("""
        SELECT DISTINCT si.ingredient 
        FROM StockIngredient si
        JOIN si.batches b
        WHERE b.expirationDate < :today AND b.quantity > 0
        """)
    List<com.example.fuegoypan.model.Ingredient> findIngredientsWithExpiredBatches(
            @Param("today") LocalDate today);


    @Query("""
        SELECT DISTINCT si.ingredient 
        FROM StockIngredient si
        JOIN si.batches b
        WHERE b.expirationDate BETWEEN :today AND :maxDate 
        AND b.quantity > 0
        """)
    List<com.example.fuegoypan.model.Ingredient> findIngredientsWithBatchesExpiringSoon(
            @Param("today") LocalDate today,
            @Param("maxDate") LocalDate maxDate);
}