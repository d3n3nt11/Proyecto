package com.example.fuegoypan.dto;

import com.example.fuegoypan.model.SaleStatus;
import lombok.Data;

import java.util.List;

@Data
public class SaleCreateDTO {
    private Long userId;
    private List<SaleLineCreateDTO> lines;
    private SaleStatus status; // OPEN, CLOSED, etc.
}