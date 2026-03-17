package com.example.fuegoypan.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "stock_ingredient")
@Getter
@Setter
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

    private Double minStock; //para las alertas

    private LocalDate expirationDate;
}
