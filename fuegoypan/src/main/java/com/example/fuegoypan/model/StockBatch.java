package com.example.fuegoypan.model;

import com.fasterxml.jackson.annotation.JsonBackReference;  // 🔹 IMPORTANTE
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

    // 🔹 CAMBIO: @JsonBackReference indica que ESTE lado se OMITE al serializar
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_ingredient_id", nullable = false)
    @JsonBackReference  // ← "Hijo": se excluye para evitar bucle infinito
    private StockIngredient stockIngredient;

    private String batchNumber;
    private Double quantity;
    private LocalDate expirationDate;
    private LocalDateTime createdAt;

    // Constructor útil
    public StockBatch(StockIngredient stockIngredient, Double quantity, LocalDate expirationDate) {
        this.stockIngredient = stockIngredient;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.createdAt = LocalDateTime.now();
    }

    // Métodos de utilidad...
    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

    public void consume(Double amount) {
        if (quantity != null && amount != null) {
            this.quantity = Math.max(0, quantity - amount);
        }
    }
}