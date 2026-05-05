package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.dto.StockAlertDTO;
import com.example.fuegoypan.dto.StockIngredientDTO;
import com.example.fuegoypan.model.StockIngredient;
import com.example.fuegoypan.repository.StockIngredientRepo;
import com.example.fuegoypan.service.StockIngredientService;
import com.example.fuegoypan.service.WhatsAppService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockIngredientServiceImpl implements StockIngredientService {

    private final StockIngredientRepo stockRepo;
    private final WhatsAppService whatsappService;

    public StockIngredientServiceImpl(StockIngredientRepo stockRepo, WhatsAppService whatsappService) {
        this.stockRepo = stockRepo;
        this.whatsappService = whatsappService;
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

        stock.setCurrentStock(newStock);
        stockRepo.save(stock);

        //  ALERTA INMEDIATA
        if (stock.getCurrentStock() < stock.getMinStock()) {
            whatsappService.sendMessage(
                    "ALERTA STOCK BAJO: " + stock.getIngredient().getName() +
                            " (" + stock.getCurrentStock() + "/" + stock.getMinStock() + ")"
            );
        }

        return mapToDTO(stock);
    }

    @Override
    public List<StockAlertDTO> getIngredientsBelowMin() {
        return stockRepo.findLowStock();
    }

    @Override
    public List<StockIngredientDTO> getIngredientsExpired() {
        LocalDate today = LocalDate.now();
        return stockRepo.findAll().stream()
                .filter(s -> s.getExpirationDate() != null && !s.getExpirationDate().isAfter(today))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StockIngredientDTO updateMinStock(Long ingredientId, Double minStock) {
        StockIngredient stock = stockRepo.findById(ingredientId)
                .orElseThrow(() -> new RuntimeException("Stock no encontrado"));

        stock.setMinStock(minStock);
        StockIngredient saved = stockRepo.save(stock);

        return mapToDTO(saved); // Usa el metodo interno de mapeo o crea uno nuevo
    }

    private StockIngredientDTO mapToDTO(StockIngredient stock) {
        StockIngredientDTO dto = new StockIngredientDTO();
        dto.setIngredientId(stock.getIngredient().getId());
        dto.setIngredientName(stock.getIngredient().getName());
        dto.setCurrentStock(stock.getCurrentStock());
        dto.setMinStock(stock.getMinStock());
        dto.setExpirationDate(stock.getExpirationDate());
        dto.setUnit(stock.getIngredient().getUnit());
        dto.setImage(stock.getIngredient().getImage());
        return dto;
    }
}