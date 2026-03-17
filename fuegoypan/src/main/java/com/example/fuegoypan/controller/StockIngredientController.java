package com.example.fuegoypan.controller;

import com.example.fuegoypan.dto.StockIngredientDTO;
import com.example.fuegoypan.service.StockIngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockIngredientController {

    private final StockIngredientService stockService;

    public StockIngredientController(StockIngredientService stockService) {
        this.stockService = stockService;
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
    public ResponseEntity<List<StockIngredientDTO>> getBelowMin() {
        return ResponseEntity.ok(stockService.getIngredientsBelowMin());
    }

    @GetMapping("/expired")
    public ResponseEntity<List<StockIngredientDTO>> getExpired() {
        return ResponseEntity.ok(stockService.getIngredientsExpired());
    }
}