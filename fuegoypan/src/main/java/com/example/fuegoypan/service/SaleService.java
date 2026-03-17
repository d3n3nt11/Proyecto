package com.example.fuegoypan.service;

import com.example.fuegoypan.dto.SaleCreateDTO;
import com.example.fuegoypan.dto.SaleDTO;

import java.util.List;

public interface SaleService {
    SaleDTO createSale(SaleCreateDTO dto);
    List<SaleDTO> getAll();
    SaleDTO getById(Long id);
}