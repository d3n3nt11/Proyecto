package com.example.fuegoypan.controller;

import com.example.fuegoypan.dto.BatchReplenishmentDTO;
import com.example.fuegoypan.dto.StockAlertDTO;
import com.example.fuegoypan.dto.StockIngredientDTO;
import com.example.fuegoypan.model.StockBatch;
import com.example.fuegoypan.service.StockIngredientService;
import com.example.fuegoypan.service.StockBatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockIngredientController {

    private final StockIngredientService stockService;
    private final StockBatchService batchService;


    public StockIngredientController(
            StockIngredientService stockService,
            StockBatchService batchService
    ) {
        this.stockService = stockService;
        this.batchService = batchService;
    }

    @GetMapping
    public ResponseEntity<List<StockIngredientDTO>> getAllStock() {
        return ResponseEntity.ok(stockService.getAllStock());
    }

    @GetMapping("/{ingredientId}")
    public ResponseEntity<StockIngredientDTO> getByIngredient(@PathVariable Long ingredientId) {
        return ResponseEntity.ok(stockService.getByIngredientId(ingredientId));
    }

    @PutMapping("/{ingredientId}")
    public ResponseEntity<StockIngredientDTO> updateStock(
            @PathVariable Long ingredientId,
            @RequestParam Double newStock,
            @RequestParam(defaultValue = "false") boolean checkMin
    ) {
        return ResponseEntity.ok(stockService.updateStock(ingredientId, newStock, checkMin));
    }

    @GetMapping("/below-min")
    public ResponseEntity<List<StockAlertDTO>> getBelowMin() {
        return ResponseEntity.ok(stockService.getIngredientsBelowMin());
    }

    @GetMapping("/expired")
    public ResponseEntity<List<StockIngredientDTO>> getExpired() {
        return ResponseEntity.ok(stockService.getIngredientsExpired());
    }

    @PatchMapping("/{id}/min-stock")
    public ResponseEntity<StockIngredientDTO> updateMinStock(
            @PathVariable Long id,
            @RequestParam Double minStock) {
        return ResponseEntity.ok(stockService.updateMinStock(id, minStock));
    }


    @PostMapping("/batch")
    public ResponseEntity<?> addStockBatch(@RequestBody BatchReplenishmentDTO dto) {
        try {
            if (dto.getIngredientId() == null || dto.getIngredientId() <= 0) {
                return ResponseEntity.badRequest().body("ingredientId es requerido");
            }
            if (dto.getQuantity() == null || dto.getQuantity() <= 0) {
                return ResponseEntity.badRequest().body("quantity debe ser mayor a 0");
            }
            if (dto.getExpirationDate() == null) {
                return ResponseEntity.badRequest().body("expirationDate es requerida");
            }

            StockBatch batch = batchService.addBatch(
                    dto.getIngredientId(),
                    dto.getQuantity(),
                    dto.getExpirationDate(),
                    dto.getBatchNumber()
            );

            return ResponseEntity.ok(batch);

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al crear lote: " + e.getMessage());
        }
    }
}