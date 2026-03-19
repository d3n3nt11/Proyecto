package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.dto.IngredientDTO;
import com.example.fuegoypan.dto.IngredientCreateDTO;
import com.example.fuegoypan.model.Ingredient;
import com.example.fuegoypan.repository.IngredientRepo;
import com.example.fuegoypan.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepo ingredientRepo;

    public IngredientServiceImpl(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public IngredientDTO createIngredient(IngredientCreateDTO dto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(dto.getName());
        ingredient.setUnit(dto.getUnit());

        Ingredient saved = ingredientRepo.save(ingredient);
        return mapToDTO(saved);
    }

    @Override
    public IngredientDTO updateIngredient(Long id, IngredientCreateDTO dto) {
        Ingredient ingredient = ingredientRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingrediente no encontrado"));

        ingredient.setName(dto.getName());
        ingredient.setUnit(dto.getUnit());

        Ingredient saved = ingredientRepo.save(ingredient);
        return mapToDTO(saved);
    }

    @Override
    public List<IngredientDTO> getAll() {
        return ingredientRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public IngredientDTO getById(Long id) {
        return ingredientRepo.findById(id).map(this::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingrediente no encontrado"));
    }

    @Override
    public Optional<IngredientDTO> getEntityById(Long id) {
        return ingredientRepo.findById(id).map(this::mapToDTO);
    }

    private IngredientDTO mapToDTO(Ingredient ingredient) {
        IngredientDTO dto = new IngredientDTO();
        dto.setId(ingredient.getId());
        dto.setName(ingredient.getName());
        dto.setUnit(ingredient.getUnit());
        return dto;
    }
}