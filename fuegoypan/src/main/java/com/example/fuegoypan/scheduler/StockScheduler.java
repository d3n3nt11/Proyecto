package com.example.fuegoypan.scheduler;

import com.example.fuegoypan.dto.ExpiredBatchDTO;
import com.example.fuegoypan.dto.StockAlertDTO;
import com.example.fuegoypan.service.StockIngredientService;
import com.example.fuegoypan.service.StockBatchService;
import com.example.fuegoypan.service.WhatsAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StockScheduler {

    private final StockIngredientService stockService;
    private final StockBatchService batchService;  // 🔹 Nuevo service
    private final WhatsAppService whatsappService;

    private boolean stockAlertSent = false;
    private boolean expiredAlertSent = false;

    // 🔹 Verificar stock mínimo cada 5 segundos (para desarrollo)
    @Scheduled(fixedRate = 5000)
    public void checkMinStock() {
        var lowStock = stockService.getIngredientsBelowMin();

        if (!lowStock.isEmpty() && !stockAlertSent) {
            StringBuilder msg = new StringBuilder("⚠️ STOCK BAJO:\n\n");
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
            stockAlertSent = true;
        }

        if (lowStock.isEmpty()) {
            stockAlertSent = false;
        }
    }

    // 🔹 MODIFICADO: Verificar caducidad a nivel de LOTE (no solo ingrediente)
    @Scheduled(cron = "0 0 8 * * ?")  // Diariamente a las 8:00 AM
    public void checkExpiredBatches() {
        List<ExpiredBatchDTO> expiredBatches = batchService.getExpiredBatches();

        if (!expiredBatches.isEmpty() && !expiredAlertSent) {
            StringBuilder msg = new StringBuilder("🚨 LOTEs CADUCADOS:\n");
            msg.append("Retirar inmediatamente del inventario\n\n");

            expiredBatches.forEach(batch ->
                    msg.append("• ")
                            .append(batch.getIngredientName())
                            .append(batch.getBatchNumber() != null ? " [Lote: " + batch.getBatchNumber() + "]" : "")
                            .append("\n")
                            .append("  📅 Caducó: ")
                            .append(batch.getExpirationDate())
                            .append(" (hace ")
                            .append(batch.getDaysSinceExpired())
                            .append(" días)\n")
                            .append("  📦 Cantidad pendiente: ")
                            .append(batch.getQuantity())
                            .append("\n\n")
            );

            whatsappService.sendMessage(msg.toString());
            expiredAlertSent = true;
        }

        if (expiredBatches.isEmpty()) {
            expiredAlertSent = false;
        }
    }

    // 🔹 NUEVO: Alerta preventiva de caducidad próxima (3 días antes)
    @Scheduled(cron = "0 0 9 * * ?")  // Diariamente a las 9:00 AM
    public void checkExpiringSoon() {
        List<ExpiredBatchDTO> expiringSoon = batchService.getBatchesExpiringInDays(3);

        if (!expiringSoon.isEmpty()) {
            StringBuilder msg = new StringBuilder("⏰ CADUCIDAD PRÓXIMA (3 días):\n\n");
            expiringSoon.forEach(batch ->
                    msg.append("• ")
                            .append(batch.getIngredientName())
                            .append(" [")
                            .append(batch.getBatchNumber())
                            .append("]\n")
                            .append("  📅 Caduca: ")
                            .append(batch.getExpirationDate())
                            .append(" (en ")
                            .append(3 - batch.getDaysSinceExpired())
                            .append(" días)\n")
                            .append("  📦 Cantidad: ")
                            .append(batch.getQuantity())
                            .append("\n\n")
            );
            whatsappService.sendMessage(msg.toString());
        }
    }
}