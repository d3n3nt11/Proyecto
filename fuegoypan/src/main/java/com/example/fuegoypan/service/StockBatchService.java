package com.example.fuegoypan.service;

import com.example.fuegoypan.dto.ExpiredBatchDTO;
import com.example.fuegoypan.model.Ingredient;
import com.example.fuegoypan.model.StockBatch;
import com.example.fuegoypan.model.StockIngredient;
import com.example.fuegoypan.repository.StockBatchRepo;
import com.example.fuegoypan.repository.StockIngredientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StockBatchService {

    private final StockBatchRepo batchRepo;
    private final StockIngredientRepo stockRepo;


    public boolean consumeIngredientFIFO(Long ingredientId, Double quantityNeeded, Long saleId) {
        List<StockBatch> batches = batchRepo.findValidBatchesByIngredient(
                ingredientId, LocalDate.now());

        Double remaining = quantityNeeded;

        for (StockBatch batch : batches) {
            if (remaining <= 0 || remaining <= 0.001) break; // Evitar errores de precisión

            Double toConsume = Math.min(batch.getQuantity(), remaining);
            batch.consume(toConsume);
            batchRepo.save(batch);


            remaining -= toConsume;
        }


        updateStockIngredientTotal(ingredientId);

        return remaining <= 0.001;
    }


    public StockBatch addBatch(Long ingredientId, Double quantity, LocalDate expirationDate, String batchNumber) {
        StockIngredient stockIngredient = stockRepo.findByIngredient_Id(ingredientId)
                .orElseThrow(() -> new RuntimeException("StockIngredient no encontrado para ingredientId: " + ingredientId));


        StockBatch batch = StockBatch.builder()
                .stockIngredient(stockIngredient)
                .quantity(quantity)
                .expirationDate(expirationDate)
                .batchNumber(batchNumber)
                .createdAt(LocalDateTime.now())
                .build();

        StockBatch saved = batchRepo.save(batch);


        updateStockIngredientTotal(ingredientId);

        return saved;
    }


    private void updateStockIngredientTotal(Long ingredientId) {
        stockRepo.findByIngredient_Id(ingredientId).ifPresent(stock -> {
            Double total = batchRepo.getTotalValidStockByIngredient(ingredientId, LocalDate.now());
            stock.setCurrentStock(total);

            // Actualizar fecha de caducidad más próxima
            List<StockBatch> validBatches = batchRepo.findValidBatchesByIngredient(ingredientId, LocalDate.now());
            stock.setExpirationDate(validBatches.stream()
                    .min((b1, b2) -> b1.getExpirationDate().compareTo(b2.getExpirationDate()))
                    .map(StockBatch::getExpirationDate)
                    .orElse(null));

            stockRepo.save(stock);
        });
    }


    public List<ExpiredBatchDTO> getExpiredBatches() {
        return batchRepo.findExpiredBatchesWithStock(LocalDate.now())
                .stream()
                .map(ExpiredBatchDTO::fromBatch)
                .collect(Collectors.toList());
    }


    public List<ExpiredBatchDTO> getBatchesExpiringInDays(int days) {
        LocalDate today = LocalDate.now();
        LocalDate maxDate = today.plusDays(days);

        return batchRepo.findBatchesExpiringSoon(today, maxDate)
                .stream()
                .map(ExpiredBatchDTO::fromBatch)
                .collect(Collectors.toList());
    }


    public boolean hasEnoughStock(Long ingredientId, Double quantity) {
        Double available = batchRepo.getTotalValidStockByIngredient(ingredientId, LocalDate.now());
        return available != null && available >= quantity;
    }
}