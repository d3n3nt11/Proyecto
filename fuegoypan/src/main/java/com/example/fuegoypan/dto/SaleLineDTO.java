package com.example.fuegoypan.dto;

import lombok.Data;

@Data
public class SaleLineDTO {
    private Long id;
    private Long productId;
    private Integer quantity;
    private Double unitPrice;
}