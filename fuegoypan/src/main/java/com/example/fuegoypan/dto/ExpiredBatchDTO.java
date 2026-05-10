package com.example.fuegoypan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpiredBatchDTO {

    private Long batchId;
    private String ingredientName;
    private String batchNumber;
    private Double quantity;
    private LocalDate expirationDate;
    private Integer daysSinceExpired;

    public static ExpiredBatchDTO fromBatch(com.example.fuegoypan.model.StockBatch batch) {
        return ExpiredBatchDTO.builder()
                .batchId(batch.getId())  // ← Ahora sí funcionará
                .ingredientName(batch.getStockIngredient().getIngredient().getName())
                .batchNumber(batch.getBatchNumber())
                .quantity(batch.getQuantity())
                .expirationDate(batch.getExpirationDate())
                .daysSinceExpired(java.time.Period.between(
                        batch.getExpirationDate(),
                        LocalDate.now()).getDays())
                .build();
    }
}