package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.model.Sale;
import com.example.fuegoypan.model.StockMovement;
import com.example.fuegoypan.repository.SaleRepo;
import com.example.fuegoypan.repository.StockMovementRepo;
import com.example.fuegoypan.service.ReportService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final SaleRepo saleRepository;
    private final StockMovementRepo stockMovementRepo;

    public ReportServiceImpl(SaleRepo saleRepository, StockMovementRepo stockMovementRepo) {
        this.saleRepository = saleRepository;
        this.stockMovementRepo = stockMovementRepo;
    }

    // =========================
    // 📊 VENTAS CSV
    // =========================
    @Override
    public byte[] generateSalesCsv(String start, String end) {

        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(end).atTime(23, 59, 59);

        List<Sale> sales = saleRepository.findSalesBetween(startDate, endDate);

        StringBuilder csv = new StringBuilder();

        // BOM UTF-8 (IMPORTANTE PARA EXCEL)
        String BOM = "\uFEFF";

        csv.append(BOM);
        csv.append("ID;Fecha;Total;Estado;Usuario\n");

        for (Sale s : sales) {

            csv.append(s.getId()).append(";");
            csv.append(s.getDate() != null ? s.getDate().toString().replace("T", " ") : "").append(";");
            csv.append(s.getTotal()).append(";");
            csv.append(s.getStatus()).append(";");
            csv.append(s.getUser() != null ? s.getUser().getName() : "").append("\n");
        }

        return csv.toString().getBytes(StandardCharsets.UTF_8);
    }

    // =========================
    // 📉 STOCK MOVEMENTS CSV
    // =========================
    @Override
    public byte[] generateStockMovementsCsv(String start, String end) {

        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(end).atTime(23, 59, 59);

        List<StockMovement> movements =
                stockMovementRepo.findByCreatedAtBetween(startDate, endDate);

        StringBuilder csv = new StringBuilder();

        // BOM UTF-8 (IMPORTANTE)
        String BOM = "\uFEFF";

        csv.append(BOM);
        csv.append("ID;Ingrediente;Cantidad;Tipo;Fecha;VentaID\n");

        for (StockMovement m : movements) {

            csv.append(m.getId()).append(";");
            csv.append(m.getIngredient() != null ? m.getIngredient().getName() : "").append(";");
            csv.append(m.getQuantity()).append(";");
            csv.append(m.getType()).append(";");

            // 🔥 fecha limpia para Excel
            csv.append(m.getCreatedAt() != null
                    ? m.getCreatedAt().toString().replace("T", " ")
                    : "").append(";");

            // venta opcional
            if (m.getSale() != null) {
                csv.append(m.getSale().getId());
            }

            csv.append("\n");
        }

        return csv.toString().getBytes(StandardCharsets.UTF_8);
    }
}