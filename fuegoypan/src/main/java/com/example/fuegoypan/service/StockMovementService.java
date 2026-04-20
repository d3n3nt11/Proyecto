package com.example.fuegoypan.service;

import com.example.fuegoypan.dto.StockMovementDTO;

public interface StockMovementService {

    void createMovement(StockMovementDTO dto);

    void registerSaleConsumption(Long saleId);

}