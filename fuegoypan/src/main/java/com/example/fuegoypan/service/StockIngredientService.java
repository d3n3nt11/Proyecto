package com.example.fuegoypan.service;

import com.example.fuegoypan.dto.StockAlertDTO;
import com.example.fuegoypan.dto.StockIngredientDTO;

import java.util.List;

public interface StockIngredientService {

    List<StockIngredientDTO> getAllStock(); // Listar todo el stock

    StockIngredientDTO getByIngredientId(Long ingredientId); // Consultar stock de un ingrediente

    StockIngredientDTO updateStock(Long ingredientId, Double newStock, boolean checkMin); // Actualizar stock manualmente

    List<StockAlertDTO> getIngredientsBelowMin(); // Para alertas de stock mínimo

    List<StockIngredientDTO> getIngredientsExpired(); // Para alertas de caducidad

    StockIngredientDTO updateMinStock(Long ingredientId, Double minStock);
}