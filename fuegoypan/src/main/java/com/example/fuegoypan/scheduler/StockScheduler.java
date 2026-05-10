package com.example.fuegoypan.scheduler;

import com.example.fuegoypan.dto.ExpiredBatchDTO;
import com.example.fuegoypan.dto.StockAlertDTO;
import com.example.fuegoypan.service.StockIngredientService;
import com.example.fuegoypan.service.StockBatchService;
import com.example.fuegoypan.service.WhatsAppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class StockScheduler {

    private final StockIngredientService stockService;
    private final StockBatchService batchService;
    private final WhatsAppService whatsappService;


    private boolean expiredAlertSent = false;
    private boolean expiringSoonAlertSent = false;
    private boolean lowStockAlertSent = false;


    @Scheduled(cron = "0 0 8 * * ?")
    public void checkExpiredIngredients() {
        log.info("Verificando ingredientes caducados...");


        List<ExpiredBatchDTO> expiredBatches = batchService.getExpiredBatches();

        if (!expiredBatches.isEmpty() && !expiredAlertSent) {
            sendExpiredAlert(expiredBatches);
            expiredAlertSent = true;
            log.warn("Alerta de caducidad enviada: {} lotes afectados", expiredBatches.size());
        }

        // Reset flag si ya no hay caducados
        if (expiredBatches.isEmpty() && stockService.getIngredientsExpired().isEmpty()) {
            expiredAlertSent = false;
        }
    }


    @Scheduled(cron = "0 0 9 * * ?")
    public void checkExpiringSoon() {
        log.info("Verificando lotes por caducar (próximos 3 días)...");

        List<ExpiredBatchDTO> expiringSoon = batchService.getBatchesExpiringInDays(3);

        if (!expiringSoon.isEmpty() && !expiringSoonAlertSent) {
            sendExpiringSoonAlert(expiringSoon);
            expiringSoonAlertSent = true;
            log.info("Alerta preventiva enviada: {} lotes por caducar", expiringSoon.size());
        }

        // Reset flag si ya no hay lotes próximos a caducar
        if (expiringSoon.isEmpty()) {
            expiringSoonAlertSent = false;
        }
    }


    @Scheduled(cron = "0 0 * * * ?")
    public void checkLowStock() {
        log.debug("Verificando stock bajo...");

        List<StockAlertDTO> lowStock = stockService.getIngredientsBelowMin();

        if (!lowStock.isEmpty() && !lowStockAlertSent) {
            sendLowStockAlert(lowStock);
            lowStockAlertSent = true;
            log.warn("Alerta de stock bajo enviada: {} ingredientes", lowStock.size());
        }


        if (lowStock.isEmpty()) {
            lowStockAlertSent = false;
        }
    }


    private void sendExpiredAlert(List<ExpiredBatchDTO> expiredBatches) {
        StringBuilder msg = new StringBuilder(" LOTEs CADUCADOS - RETIRAR INMEDIATAMENTE:\n\n");

        expiredBatches.forEach(batch ->
                msg.append("• ")
                        .append(batch.getIngredientName())
                        .append(batch.getBatchNumber() != null ? " [Lote: " + batch.getBatchNumber() + "]" : "")
                        .append("\n")
                        .append("  Caducó: ")
                        .append(batch.getExpirationDate())
                        .append(" (hace ")
                        .append(batch.getDaysSinceExpired())
                        .append(" días)\n")
                        .append("  Cantidad pendiente: ")
                        .append(batch.getQuantity())
                        .append("\n\n")
        );

        msg.append("Acciones requeridas:\n")
                .append("1. Retirar del inventario\n")
                .append("2. Registrar como merma\n")
                .append("3. Revisar fechas en próximos pedidos");

        whatsappService.sendMessage(msg.toString());
    }

    private void sendExpiredIngredientAlert(List<StockAlertDTO> expiredIngredients) {
        StringBuilder msg = new StringBuilder("⚠INGREDIENTES CADUCADOS:\n\n");

        expiredIngredients.forEach(stock ->
                msg.append("- ")
                        .append(stock.getIngredientName())
                        .append(" (Stock actual: ")
                        .append(stock.getCurrentStock())
                        .append(")")
                        .append("\n")
        );

        msg.append("\n🔍 Verificar lotes individuales en el sistema para más detalles.");
        whatsappService.sendMessage(msg.toString());
    }

    private void sendExpiringSoonAlert(List<ExpiredBatchDTO> expiringSoon) {
        StringBuilder msg = new StringBuilder("CADUCIDAD PRÓXIMA (3 días):\n\n");

        expiringSoon.forEach(batch ->
                msg.append("• ")
                        .append(batch.getIngredientName())
                        .append(batch.getBatchNumber() != null ? " [Lote: " + batch.getBatchNumber() + "]" : "")
                        .append("\n")
                        .append("  Caduca: ")
                        .append(batch.getExpirationDate())
                        .append("\n")
                        .append("  Cantidad: ")
                        .append(batch.getQuantity())
                        .append("\n\n")
        );

        msg.append(" Recomendación: Usar primero estos lotes en preparaciones.");
        whatsappService.sendMessage(msg.toString());
    }

    private void sendLowStockAlert(List<StockAlertDTO> lowStock) {
        StringBuilder msg = new StringBuilder(" STOCK BAJO - REPOSICIÓN URGENTE:\n\n");

        lowStock.forEach(stock ->
                msg.append("- ")
                        .append(stock.getIngredientName())
                        .append(" (")
                        .append(stock.getCurrentStock())
                        .append("/")
                        .append(stock.getMinStock())
                        .append(" ")
                        .append(stock.getUnit() != null ? stock.getUnit() : "und")
                        .append(")\n")
        );

        msg.append("\n🛒 Contactar con proveedores para reposición.");
        whatsappService.sendMessage(msg.toString());
    }

}