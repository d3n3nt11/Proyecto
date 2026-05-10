package com.example.fuegoypan.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stock_ingredient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockIngredient {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private Double currentStock;
    private Double maxStock;
    private Double minStock;
    private LocalDate expirationDate;


    @OneToMany(mappedBy = "stockIngredient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<StockBatch> batches = new ArrayList<>();


    public Double getTotalValidStock() {
        if (batches == null) return 0.0;
        return batches.stream()
                .filter(b -> !b.isExpired() && b.getQuantity() != null && b.getQuantity() > 0)
                .mapToDouble(StockBatch::getQuantity)
                .sum();
    }

    public StockBatch getEarliestValidBatch() {
        if (batches == null) return null;
        return batches.stream()
                .filter(b -> !b.isExpired() && b.getQuantity() != null && b.getQuantity() > 0)
                .min((b1, b2) -> {
                    int dateCompare = b1.getExpirationDate().compareTo(b2.getExpirationDate());
                    return dateCompare != 0 ? dateCompare : b1.getCreatedAt().compareTo(b2.getCreatedAt());
                })
                .orElse(null);
    }

    public void addBatch(Double quantity, LocalDate expirationDate) {
        StockBatch batch = new StockBatch(this, quantity, expirationDate);
        this.batches.add(batch);
        this.currentStock = getTotalValidStock();
        this.expirationDate = getEarliestValidBatch() != null ?
                getEarliestValidBatch().getExpirationDate() : null;
    }
}