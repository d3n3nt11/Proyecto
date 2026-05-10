package com.example.fuegoypan.service;

import com.example.fuegoypan.dto.StockAlertDTO;
import com.example.fuegoypan.dto.StockIngredientDTO;

import java.util.List;

public interface StockIngredientService {

    List<StockIngredientDTO> getAllStock();

    StockIngredientDTO getByIngredientId(Long ingredientId);

    StockIngredientDTO updateStock(Long ingredientId, Double newStock, boolean checkMin);

    List<StockAlertDTO> getIngredientsBelowMin();

    List<StockIngredientDTO> getIngredientsExpired();

    StockIngredientDTO updateMinStock(Long ingredientId, Double minStock);
}