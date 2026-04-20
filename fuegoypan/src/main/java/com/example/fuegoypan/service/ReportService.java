package com.example.fuegoypan.service;

public interface ReportService {

    byte[] generateSalesCsv(String start, String end);
    byte[] generateStockMovementsCsv(String start, String end);
}