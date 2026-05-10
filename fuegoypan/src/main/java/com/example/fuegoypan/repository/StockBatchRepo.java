package com.example.fuegoypan.repository;

import com.example.fuegoypan.model.StockBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockBatchRepo extends JpaRepository<StockBatch, Long> {


    @Query("""
        SELECT b FROM StockBatch b 
        WHERE b.stockIngredient.ingredient.id = :ingredientId 
        AND b.expirationDate >= :today 
        AND b.quantity > 0 
        ORDER BY b.expirationDate ASC, b.createdAt ASC
        """)
    List<StockBatch> findValidBatchesByIngredient(
            @Param("ingredientId") Long ingredientId,
            @Param("today") LocalDate today);

    @Query("""
        SELECT COALESCE(SUM(b.quantity), 0) 
        FROM StockBatch b 
        WHERE b.stockIngredient.ingredient.id = :ingredientId 
        AND b.expirationDate >= :today
        """)
    Double getTotalValidStockByIngredient(
            @Param("ingredientId") Long ingredientId,
            @Param("today") LocalDate today);


    @Query("""
        SELECT b FROM StockBatch b 
        WHERE b.expirationDate BETWEEN :today AND :maxDate 
        AND b.quantity > 0
        ORDER BY b.expirationDate ASC
        """)
    List<StockBatch> findBatchesExpiringSoon(
            @Param("today") LocalDate today,
            @Param("maxDate") LocalDate maxDate);

    @Query("""
        SELECT b FROM StockBatch b 
        WHERE b.expirationDate < :today 
        AND b.quantity > 0
        """)
    List<StockBatch> findExpiredBatchesWithStock(@Param("today") LocalDate today);

    Optional<StockBatch> findByStockIngredientIngredientIdAndBatchNumber(
            @Param("ingredientId") Long ingredientId,
            @Param("batchNumber") String batchNumber);
}