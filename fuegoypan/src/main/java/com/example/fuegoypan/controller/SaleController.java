package com.example.fuegoypan.controller;

import com.example.fuegoypan.dto.SaleCreateDTO;
import com.example.fuegoypan.dto.SaleDTO;
import com.example.fuegoypan.dto.StatusRequest;
import com.example.fuegoypan.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<SaleDTO> createSale(@Valid @RequestBody SaleCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saleService.createSale(dto));
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAll() {
        return ResponseEntity.ok(saleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getById(id));
    }

    // 🔥 CAMBIAR ESTADO
    @PatchMapping("/{id}/status")
    public ResponseEntity<SaleDTO> updateStatus(
            @PathVariable Long id,
            @RequestBody StatusRequest request) {

        return ResponseEntity.ok(
                saleService.updateStatus(id, request.getStatus())
        );
    }

    // 🔥 CANCELAR
    @PatchMapping("/{id}/cancel")
    public ResponseEntity<SaleDTO> cancelSale(@PathVariable Long id) {
        return ResponseEntity.ok(
                saleService.cancelSale(id)
        );
    }
}