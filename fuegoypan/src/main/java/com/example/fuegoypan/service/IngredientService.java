package com.example.fuegoypan.service;


import com.example.fuegoypan.dto.IngredientDTO;
import com.example.fuegoypan.dto.IngredientCreateDTO;

import java.util.List;
import java.util.Optional;

public interface IngredientService {

    IngredientDTO createIngredient(IngredientCreateDTO dto);

    IngredientDTO updateIngredient(Long id, IngredientCreateDTO dto);

    List<IngredientDTO> getAll();

    IngredientDTO getById(Long id);

    Optional<IngredientDTO> getEntityById(Long id);
}