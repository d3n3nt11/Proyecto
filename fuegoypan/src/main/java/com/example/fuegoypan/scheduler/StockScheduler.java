package com.example.fuegoypan.scheduler;

import com.example.fuegoypan.service.StockIngredientService;
import com.example.fuegoypan.service.WhatsAppService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StockScheduler {

    private final StockIngredientService stockService;
    private final WhatsAppService whatsappService;

    // Control para evitar spam
    private boolean stockAlertSent = false;
    private boolean expiredAlertSent = false;

    public StockScheduler(StockIngredientService stockService, WhatsAppService whatsappService) {
        this.stockService = stockService;
        this.whatsappService = whatsappService;
    }

    // Verificar stock mínimo cada hora
//    @Scheduled(cron = "0 0 * * * ?")
//    public void checkMinStock() {
//
//        var lowStock = stockService.getIngredientsBelowMin();
//
//        if (!lowStock.isEmpty() && !stockAlertSent) {
//
//            StringBuilder msg = new StringBuilder(" STOCK BAJO:\n");
//            msg.append("Revisar inventario urgentemente\n\n");
//
//            lowStock.forEach(stock ->
//                    msg.append("- ")
//                            .append(stock.getIngredientName())
//                            .append(" (")
//                            .append(stock.getCurrentStock())
//                            .append("/")
//                            .append(stock.getMinStock())
//                            .append(")\n")
//            );
//
//            whatsappService.sendMessage(msg.toString());
//            stockAlertSent = true;
//        }
//
//        // Reset si ya no hay problema
//        if (lowStock.isEmpty()) {
//            stockAlertSent = false;
//        }
//    }

    @Scheduled(fixedRate = 5000)
    public void checkMinStock() {

        var lowStock = stockService.getIngredientsBelowMin();

        if (!lowStock.isEmpty()) {

            StringBuilder msg = new StringBuilder("STOCK BAJO:\n\n");

            lowStock.forEach(stock ->
                    msg.append("- ")
                            .append(stock.getIngredientName())
                            .append(" (")
                            .append(stock.getCurrentStock())
                            .append("/")
                            .append(stock.getMinStock())
                            .append(")\n")
            );

            whatsappService.sendMessage(msg.toString());
        }
    }

    // Verificar caducidad diariamente
    @Scheduled(cron = "0 0 8 * * ?")
    public void checkExpiredIngredients() {

        var expired = stockService.getIngredientsExpired();

        if (!expired.isEmpty() && !expiredAlertSent) {

            StringBuilder msg = new StringBuilder("PRODUCTOS CADUCADOS:\n");
            msg.append("Retirar inmediatamente\n\n");

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