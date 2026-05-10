package com.example.fuegoypan.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String unit; // kg, g, unidades, litros...

    @Column(name = "image")
    private String image;

    @OneToOne(mappedBy = "ingredient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private StockIngredient stock;

    public Ingredient(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }


    public Double getTotalStock() {
        return stock != null ? stock.getTotalValidStock() : 0.0;
    }

    public boolean isLowStock() {
        return stock != null && stock.getMinStock() != null &&
                getTotalStock() <= stock.getMinStock();
    }
}