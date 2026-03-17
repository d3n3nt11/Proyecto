package com.example.fuegoypan.controller;

import com.example.fuegoypan.dto.SaleCreateDTO;
import com.example.fuegoypan.dto.SaleDTO;
import com.example.fuegoypan.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleCreateDTO dto) {
        return ResponseEntity.ok(saleService.createSale(dto));
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAll() {
        return ResponseEntity.ok(saleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getById(id));
    }
}