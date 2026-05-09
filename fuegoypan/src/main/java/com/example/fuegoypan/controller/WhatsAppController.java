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

    @PostMapping(produces = "application/xml")
    public String receiveMessage(@RequestParam("Body") String body) {

        String message = body.toLowerCase().trim();

        String response;

        if (message.contains("estado") || message.contains("todo")) {
            response = buildFullStatusSimplified();
        } else if (message.contains("stock")) {
            response = buildStockResponse();
        } else if (message.contains("caduca") || message.contains("caducidad")) {
            response = buildExpiredResponse();
        } else if (message.contains("ayuda")) {
            response = "Comandos:\n- estado\n- stock\n- caducidad";
        } else {
            response = "No entiendo el comando.\nEscribe 'ayuda'";
        }

        return wrap(response);
    }

    //  Envolver respuesta para Twilio
    private String wrap(String message) {
        return """
                <Response>
                    <Message><![CDATA[%s]]></Message>
                </Response>
                """.formatted(message);
    }

    // ESTADO SIMPLIFICADO: solo "nombre: actual/min"
    private String buildFullStatusSimplified() {
        List<StockIngredientDTO> all = stockService.getAllStock();
        StringBuilder sb = new StringBuilder("📊 ESTADO GENERAL\n\n");

        for (var s : all) {
            sb.append(s.getIngredientName())
                    .append(": ")
                    .append(s.getCurrentStock())
                    .append("/")
                    .append(s.getMinStock())
                    .append("\n");
        }

        return sb.toString();
    }

    // 📦 STOCK BAJO
    private String buildStockResponse() {
        List<StockIngredientDTO> all = stockService.getAllStock();
        StringBuilder sb = new StringBuilder("📦 STOCK BAJO\n\n");

        boolean hasLow = false;
        for (var s : all) {
            if (s.getCurrentStock() < s.getMinStock()) {
                hasLow = true;
                sb.append(s.getIngredientName())
                        .append(": ")
                        .append(s.getCurrentStock())
                        .append("/")
                        .append(s.getMinStock())
                        .append("\n");
            }
        }

        if (!hasLow) sb.append("✅ Todo correcto");

        return sb.toString();
    }

    // ⏰ CADUCADOS
    private String buildExpiredResponse() {
        List<StockIngredientDTO> all = stockService.getAllStock();
        StringBuilder sb = new StringBuilder("⏰ CADUCADOS\n\n");

        boolean hasExpired = false;
        LocalDate today = LocalDate.now();

        for (var s : all) {
            if (s.getExpirationDate() != null && !s.getExpirationDate().isAfter(today)) {
                hasExpired = true;
                sb.append(s.getIngredientName())
                        .append(": ")
                        .append(s.getExpirationDate())
                        .append("\n");
            }
        }

        if (!hasExpired) sb.append("✅ No hay ingredientes caducados");

        return sb.toString();
    }
}