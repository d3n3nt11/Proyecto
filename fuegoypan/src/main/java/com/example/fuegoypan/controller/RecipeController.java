package com.example.fuegoypan.controller;

import com.example.fuegoypan.dto.RecipeCreateDTO;
import com.example.fuegoypan.dto.RecipeDTO;
import com.example.fuegoypan.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> addIngredient(@RequestBody RecipeCreateDTO dto) {
        return ResponseEntity.ok(recipeService.addIngredientToProduct(dto));
    }

    @PutMapping
    public ResponseEntity<RecipeDTO> updateIngredient(@RequestBody RecipeCreateDTO dto) {
        return ResponseEntity.ok(recipeService.updateIngredientQuantity(dto));
    }

    @DeleteMapping("/{productId}/{ingredientId}")
    public ResponseEntity<Void> removeIngredient(@PathVariable Long productId, @PathVariable Long ingredientId) {
        recipeService.removeIngredientFromProduct(productId, ingredientId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<RecipeDTO>> getIngredientsByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(recipeService.getIngredientsByProduct(productId));
    }
}