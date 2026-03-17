package com.example.fuegoypan.service;

import com.example.fuegoypan.dto.RecipeCreateDTO;
import com.example.fuegoypan.dto.RecipeDTO;

import java.util.List;

public interface RecipeService {

    RecipeDTO addIngredientToProduct(RecipeCreateDTO dto);

    RecipeDTO updateIngredientQuantity(RecipeCreateDTO dto);

    void removeIngredientFromProduct(Long productId, Long ingredientId);

    List<RecipeDTO> getIngredientsByProduct(Long productId);

}