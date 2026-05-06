package com.example.fuegoypan.service;

import com.example.fuegoypan.dto.SaleDTO;
import com.example.fuegoypan.dto.StockMovementDTO;

import java.util.List;

public interface ReportService {

    byte[] generateSalesCsv(String start, String end);
    byte[] generateStockMovementsCsv(String start, String end);
    List<SaleDTO> getSalesReport(String start, String end);
    List<StockMovementDTO> getIngredientConsumptionReport(String start, String end);
    List<StockMovementDTO> getStockMovementsReport(String start, String end);
}