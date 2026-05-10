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
public class BatchReplenishmentDTO {
    private Long ingredientId;
    private Double quantity;
    private LocalDate expirationDate;
    private String batchNumber;
}