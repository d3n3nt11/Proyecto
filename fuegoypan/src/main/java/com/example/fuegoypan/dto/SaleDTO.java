package com.example.fuegoypan.dto;

import com.example.fuegoypan.model.SaleStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleDTO {
    private Long id;
    private LocalDateTime date;
    private Double total;
    private SaleStatus status;
    private Long userId;
    private List<SaleLineDTO> lines;
}