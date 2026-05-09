package com.example.fuegoypan.scheduler;

import com.example.fuegoypan.service.StockIngredientService;
import com.example.fuegoypan.service.WhatsAppService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StockScheduler {

    private final StockIngredientService stockService;
    private final WhatsAppService whatsappService;

    private boolean expiredAlertSent = false;

    public StockScheduler(
            StockIngredientService stockService,
            WhatsAppService whatsappService
    ) {
        this.stockService = stockService;
        this.whatsappService = whatsappService;
    }

    // Verificar caducidad diariamente
    @Scheduled(cron = "0 0 8 * * ?")
    public void checkExpiredIngredients() {

        var expired = stockService.getIngredientsExpired();

        if (!expired.isEmpty() && !expiredAlertSent) {

            StringBuilder msg = new StringBuilder(
                    "PRODUCTOS CADUCADOS:\n\n"
            );

            expired.forEach(stock ->
                    msg.append("- ")
                            .append(stock.getIngredientName())
                            .append(" (Caduca: ")
                            .append(stock.getExpirationDate())
                            .append(")\n")
            );

            whatsappService.sendMessage(msg.toString());

            expiredAlertSent = true;
        }

        // Reset si ya no hay productos caducados
        if (expired.isEmpty()) {
            expiredAlertSent = false;
        }
    }
}