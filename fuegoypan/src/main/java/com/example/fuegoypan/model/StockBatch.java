package com.example.fuegoypan.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_batch")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_ingredient_id", nullable = false)
    private StockIngredient stockIngredient;

    private String batchNumber;
    private Double quantity;
    private LocalDate expirationDate;
    private LocalDateTime createdAt;


    public StockBatch(StockIngredient stockIngredient, Double quantity, LocalDate expirationDate) {
        this.stockIngredient = stockIngredient;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.createdAt = LocalDateTime.now();
    }


    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

    public boolean hasEnoughStock(Double requested) {
        return quantity != null && quantity >= requested;
    }

    public void consume(Double amount) {
        if (quantity != null && amount != null) {
            this.quantity = Math.max(0, quantity - amount);
        }
    }
}