package com.example.fuegoypan.repository;

import com.example.fuegoypan.model.MovementType;
import com.example.fuegoypan.model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StockMovementRepo extends JpaRepository<StockMovement, Long> {

    List<StockMovement> findByIngredientId(Long ingredientId);

    List<StockMovement> findByCreatedAtBetween(
            LocalDateTime start,
            LocalDateTime end
    );

    boolean existsBySale_IdAndType(Long saleId, MovementType type);

    @Query("""
        SELECT sm.ingredient.name, SUM(ABS(sm.quantity))
        FROM StockMovement sm
        WHERE sm.type = com.example.fuegoypan.model.MovementType.SALE
        AND sm.createdAt BETWEEN :start AND :end
        GROUP BY sm.ingredient.name
        ORDER BY SUM(ABS(sm.quantity)) DESC
        """)
    List<Object[]> getIngredientConsumption(
            LocalDateTime start,
            LocalDateTime end
    );
}