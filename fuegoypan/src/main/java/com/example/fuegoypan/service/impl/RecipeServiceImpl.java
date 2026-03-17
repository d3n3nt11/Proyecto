package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.dto.RecipeCreateDTO;
import com.example.fuegoypan.dto.RecipeDTO;
import com.example.fuegoypan.model.*;
import com.example.fuegoypan.repository.*;
import com.example.fuegoypan.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepo recipeRepo;
    private final ProductRepo productRepo;
    private final IngredientRepo ingredientRepo;

    public RecipeServiceImpl(RecipeRepo recipeRepo,
                             ProductRepo productRepo,
                             IngredientRepo ingredientRepo) {
        this.recipeRepo = recipeRepo;
        this.productRepo = productRepo;
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public RecipeDTO addIngredientToProduct(RecipeCreateDTO dto) {

        Product product = productRepo.findById(dto.getProductId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        Ingredient ingredient = ingredientRepo.findById(dto.getIngredientId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingrediente no encontrado"));

        Recipe recipe = new Recipe();
        recipe.setId(new RecipeId(product.getId(), ingredient.getId()));
        recipe.setProduct(product);
        recipe.setIngredient(ingredient);
        recipe.setQuantity(dto.getQuantity());

        Recipe saved = recipeRepo.save(recipe);

        return mapToDTO(saved);
    }

    @Override
    public RecipeDTO updateIngredientQuantity(RecipeCreateDTO dto) {

        RecipeId id = new RecipeId(dto.getProductId(), dto.getIngredientId());
        Recipe recipe = recipeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receta no encontrada"));

        recipe.setQuantity(dto.getQuantity());
        Recipe saved = recipeRepo.save(recipe);

        return mapToDTO(saved);
    }

    @Override
    public void removeIngredientFromProduct(Long productId, Long ingredientId) {
        RecipeId id = new RecipeId(productId, ingredientId);
        Recipe recipe = recipeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receta no encontrada"));
        recipeRepo.delete(recipe);
    }

    @Override
    public List<RecipeDTO> getIngredientsByProduct(Long productId) {

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        return product.getRecipeItems().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private RecipeDTO mapToDTO(Recipe recipe) {
        RecipeDTO dto = new RecipeDTO();
        dto.setProductId(recipe.getProduct().getId());
        dto.setIngredientId(recipe.getIngredient().getId());
        dto.setQuantity(recipe.getQuantity());
        dto.setIngredientName(recipe.getIngredient().getName());
        return dto;
    }
}