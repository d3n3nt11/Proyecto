package com.example.fuegoypan.controller;

import com.example.fuegoypan.dto.StockIngredientDTO;
import com.example.fuegoypan.service.StockIngredientService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/whatsapp")
public class WhatsAppController {

    private final StockIngredientService stockService;

    public WhatsAppController(StockIngredientService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public String receiveMessage(@RequestParam("Body") String body) {

        String message = body.toLowerCase();

        if (message.contains("estado") || message.contains("todo")) {
            return buildFullStatus();
        }

        if (message.contains("stock")) {
            return buildStockResponse();
        }

        if (message.contains("caduca") || message.contains("caducidad")) {
            return buildExpiredResponse();
        }

        if (message.contains("ayuda")) {
            return "Comandos:\n- stock\n- caducidad\n- estado";
        }

        return "No entiendo el comando.\nEscribe 'ayuda'";
    }

    //  VER TODO
    private String buildFullStatus() {
        List<StockIngredientDTO> all = stockService.getAllStock();

        StringBuilder response = new StringBuilder("📊 ESTADO GENERAL:\n");

        LocalDate today = LocalDate.now();

        all.forEach(s -> {
            boolean lowStock = s.getCurrentStock() < s.getMinStock();
            boolean expired = s.getExpirationDate() != null && !s.getExpirationDate().isAfter(today);

            response.append("- ")
                    .append(s.getIngredientName())
                    .append(" | En stock: ")
                    .append(s.getCurrentStock())
                    .append(" | Minimo:")
                    .append(s.getMinStock());

            if (lowStock) {
                response.append(" ⚠️ BAJO");
            }

            if (expired) {
                response.append(" ❌ CADUCADO");
            }

            response.append("\n");
        });

        return response.toString();
    }

    //  STOCK BAJO
    private String buildStockResponse() {
        List<StockIngredientDTO> all = stockService.getAllStock();

        StringBuilder response = new StringBuilder("📦 STOCK BAJO:\n");

        boolean hasLow = false;

        for (var s : all) {
            if (s.getCurrentStock() < s.getMinStock()) {
                hasLow = true;
                response.append("- ")
                        .append(s.getIngredientName())
                        .append(" (")
                        .append(s.getCurrentStock())
                        .append("/")
                        .append(s.getMinStock())
                        .append(")\n");
            }
        }

        if (!hasLow) {
            response.append("✅ No hay stock bajo");
        }

        return response.toString();
    }

    //  CADUCADOS
    private String buildExpiredResponse() {
        List<StockIngredientDTO> all = stockService.getAllStock();

        StringBuilder response = new StringBuilder("⏰ CADUCADOS:\n");

        boolean hasExpired = false;
        LocalDate today = LocalDate.now();

        for (var s : all) {
            if (s.getExpirationDate() != null && !s.getExpirationDate().isAfter(today)) {
                hasExpired = true;
                response.append("- ")
                        .append(s.getIngredientName())
                        .append(" (")
                        .append(s.getExpirationDate())
                        .append(")\n");
            }
        }

        if (!hasExpired) {
            response.append("✅ No hay ingredientes caducados");
        }

        return response.toString();
    }
}