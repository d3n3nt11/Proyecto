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
        SELECT s
        FROM StockIngredient s
        JOIN FETCH s.ingredient
        """)
    List<StockIngredient> findAllWithIngredient();


    @Query("""
        SELECT s FROM StockIngredient s
        JOIN FETCH s.ingredient
        WHERE s.ingredient.id = :ingredientId
        """)
    Optional<StockIngredient> findByIngredientIdWithIngredient(@Param("ingredientId") Long ingredientId);


    @Query("""
    SELECT new com.example.fuegoypan.dto.StockAlertDTO(
        i.name,
        s.currentStock,
        s.minStock,
        i.unit,
        CAST(s.expirationDate AS string)
    )
    FROM StockIngredient s
    JOIN s.ingredient i
    WHERE s.currentStock <= s.minStock
    """)
    List<StockAlertDTO> findLowStock();


    @Query("""
    SELECT new com.example.fuegoypan.dto.StockAlertDTO(
        i.name,
        s.currentStock,
        s.minStock
    )
    FROM StockIngredient s
    JOIN s.ingredient i
    WHERE s.currentStock <= (s.minStock * 0.5)
    """)
    List<StockAlertDTO> findCriticalStock();

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


    @Query("""
        SELECT si.ingredient.name, COUNT(b.id)
        FROM StockIngredient si
        JOIN si.batches b
        WHERE b.expirationDate < :today AND b.quantity > 0
        GROUP BY si.ingredient.name
        ORDER BY COUNT(b.id) DESC
        """)
    List<Object[]> countExpiredBatchesByIngredient(@Param("today") LocalDate today);


    @Query("""
        SELECT COALESCE(SUM(b.quantity), 0)
        FROM StockIngredient si
        JOIN si.batches b
        WHERE si.ingredient.id = :ingredientId
        AND b.expirationDate >= :today
        AND b.quantity > 0
        """)
    Double calculateValidStockByIngredient(
            @Param("ingredientId") Long ingredientId,
            @Param("today") LocalDate today);


    @Query("""
        SELECT MIN(b.expirationDate)
        FROM StockIngredient si
        JOIN si.batches b
        WHERE si.ingredient.id = :ingredientId
        AND b.quantity > 0
        """)
    LocalDate findNextExpirationDateByIngredient(@Param("ingredientId") Long ingredientId);


    @Query("""
        SELECT si, MIN(b.expirationDate) as nextExp
        FROM StockIngredient si
        JOIN si.batches b
        WHERE b.quantity > 0 AND b.expirationDate >= :today
        GROUP BY si
        ORDER BY nextExp ASC
        """)
    List<Object[]> findStockOrderedByNextExpiration(@Param("today") LocalDate today);


    @Query("""
        SELECT i.name, SUM(si.currentStock), i.unit
        FROM StockIngredient si
        JOIN si.ingredient i
        GROUP BY i.name, i.unit
        ORDER BY SUM(si.currentStock) ASC
        """)
    List<Object[]> getStockSummaryByIngredient();


    @Query("""
        SELECT si
        FROM StockIngredient si
        WHERE SIZE(si.batches) = 0
        AND si.currentStock > 0
        """)
    List<StockIngredient> findStockWithoutBatches();
}