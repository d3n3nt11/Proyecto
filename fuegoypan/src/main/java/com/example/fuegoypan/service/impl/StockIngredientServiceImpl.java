package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.dto.StockIngredientDTO;
import com.example.fuegoypan.model.StockIngredient;
import com.example.fuegoypan.repository.StockIngredientRepo;
import com.example.fuegoypan.service.StockIngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockIngredientServiceImpl implements StockIngredientService {

    private final StockIngredientRepo stockRepo;

    public StockIngredientServiceImpl(StockIngredientRepo stockRepo) {
        this.stockRepo = stockRepo;
    }

    @Override
    public List<StockIngredientDTO> getAllStock() {
        return stockRepo.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StockIngredientDTO getByIngredientId(Long ingredientId) {
        StockIngredient stock = stockRepo.findById(ingredientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock no encontrado"));
        return mapToDTO(stock);
    }

    @Override
    public StockIngredientDTO updateStock(Long ingredientId, Double newStock, boolean checkMin) {
        StockIngredient stock = stockRepo.findById(ingredientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock no encontrado"));

        stock.setMaxStock(newStock);
        stockRepo.save(stock);

        // Solo log, las alertas reales se gestionan en el Scheduler
        if (checkMin && stock.getMaxStock() < stock.getMinStock()) {
            System.out.println("ALERTA: Stock bajo de " + stock.getIngredient().getName() +
                    " (" + stock.getMaxStock() + "/" + stock.getMinStock() + ")");
        }

        return mapToDTO(stock);
    }

    @Override
    public List<StockIngredientDTO> getIngredientsBelowMin() {
        return stockRepo.findAll().stream()
                .filter(s -> s.getMaxStock() < s.getMinStock())
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StockIngredientDTO> getIngredientsExpired() {
        LocalDate today = LocalDate.now();
        return stockRepo.findAll().stream()
                .filter(s -> s.getExpirationDate() != null && !s.getExpirationDate().isAfter(today))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private StockIngredientDTO mapToDTO(StockIngredient stock) {
        StockIngredientDTO dto = new StockIngredientDTO();
        dto.setIngredientId(stock.getIngredient().getId());
        dto.setIngredientName(stock.getIngredient().getName());
        dto.setMaxStock(stock.getMaxStock());
        dto.setMinStock(stock.getMinStock());
        dto.setExpirationDate(stock.getExpirationDate());
        return dto;
    }
}