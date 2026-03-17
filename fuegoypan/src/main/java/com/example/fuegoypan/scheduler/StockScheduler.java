package com.example.fuegoypan.scheduler;

import com.example.fuegoypan.service.StockIngredientService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StockScheduler {

    private final StockIngredientService stockService;

    public StockScheduler(StockIngredientService stockService) {
        this.stockService = stockService;
    }

    // Verificar stock mínimo cada hora
    @Scheduled(cron = "0 0 * * * ?") // cada hora
    public void checkMinStock() {
        var lowStock = stockService.getIngredientsBelowMin();
        if (!lowStock.isEmpty()) {
            lowStock.forEach(stock -> {
                System.out.println("ALERTA: Stock bajo para " + stock.getIngredientName() +
                        " (" + stock.getMaxStock() + "/" + stock.getMinStock() + ")");
                //WhatsApp
            });
        }
    }

    // Verificar caducidad diariamente
    @Scheduled(cron = "0 0 8 * * ?") // todos los días a las 8:00 AM
    public void checkExpiredIngredients() {
        var expired = stockService.getIngredientsExpired();
        if (!expired.isEmpty()) {
            expired.forEach(stock -> {
                System.out.println("ALERTA: Ingrediente vencido: " + stock.getIngredientName() +
                        " (Caduca: " + stock.getExpirationDate() + ")");
                //WhatsApp
            });
        }
    }
}