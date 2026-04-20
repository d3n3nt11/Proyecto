package com.example.fuegoypan.controller;

import com.example.fuegoypan.dto.StockMovementDTO;
import com.example.fuegoypan.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock-movements")
@RequiredArgsConstructor
public class StockMovementController {

    private final StockMovementService stockMovementService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody StockMovementDTO dto) {
        stockMovementService.createMovement(dto);
        return ResponseEntity.ok().build();
    }

    // endpoint clave para ventas
    @PostMapping("/sale/{saleId}")
    public ResponseEntity<Void> processSale(@PathVariable Long saleId) {
        stockMovementService.registerSaleConsumption(saleId);
        return ResponseEntity.ok().build();
    }
}