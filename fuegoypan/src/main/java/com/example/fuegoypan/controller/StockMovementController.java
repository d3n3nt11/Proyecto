package com.example.fuegoypan.controller;

import com.example.fuegoypan.dto.StockMovementDTO;
import com.example.fuegoypan.service.StockMovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock-movements")
public class StockMovementController {

    private final StockMovementService stockMovementService;

    // Constructor manual en lugar de @RequiredArgsConstructor
    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody StockMovementDTO dto) {
        stockMovementService.createMovement(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/sale/{saleId}")
    public ResponseEntity<Void> processSale(@PathVariable Long saleId) {
        stockMovementService.registerSaleConsumption(saleId);
        return ResponseEntity.ok().build();
    }
}