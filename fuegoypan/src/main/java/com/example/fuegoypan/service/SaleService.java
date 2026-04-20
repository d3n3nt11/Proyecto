package com.example.fuegoypan.service;

import com.example.fuegoypan.dto.SaleCreateDTO;
import com.example.fuegoypan.dto.SaleDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface SaleService {
    SaleDTO createSale(SaleCreateDTO dto, Authentication auth);
    List<SaleDTO> getAll();
    SaleDTO getById(Long id);
    SaleDTO updateStatus(Long id, String status);
    SaleDTO cancelSale(Long id);
}