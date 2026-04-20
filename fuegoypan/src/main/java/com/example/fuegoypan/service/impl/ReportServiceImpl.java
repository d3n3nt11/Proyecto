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

    // Constructor manual
    public ReportServiceImpl(SaleRepo saleRepository, StockMovementRepo stockMovementRepo) {
        this.saleRepository = saleRepository;
        this.stockMovementRepo = stockMovementRepo;
    }

    @Override
    public byte[] generateSalesCsv(String start, String end) {

        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(end).atTime(23, 59, 59);

        List<Sale> sales = saleRepository.findSalesBetween(startDate, endDate);

        StringBuilder csv = new StringBuilder();

        csv.append("ID,Fecha,Total,Estado,Usuario\n");

        for (Sale s : sales) {
            csv.append(s.getId()).append(",");
            csv.append(s.getDate()).append(",");
            csv.append(s.getTotal()).append(",");
            csv.append(s.getStatus()).append(",");
            csv.append(s.getUser().getName()).append("\n");
        }

        return csv.toString().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public byte[] generateStockMovementsCsv(String start, String end) {

        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(end).atTime(23, 59, 59);

        List<StockMovement> movements =
                stockMovementRepo.findByCreatedAtBetween(startDate, endDate);

        StringBuilder csv = new StringBuilder();

        csv.append("ID,Ingrediente,Cantidad,Tipo,Fecha,Venta\n");

        for (StockMovement m : movements) {

            csv.append(m.getId()).append(",");
            csv.append(m.getIngredient().getName()).append(",");
            csv.append(m.getQuantity()).append(",");
            csv.append(m.getType()).append(",");
            csv.append(m.getCreatedAt()).append(",");

            if (m.getSale() != null) {
                csv.append(m.getSale().getId());
            }

            csv.append("\n");
        }

        return csv.toString().getBytes(StandardCharsets.UTF_8);
    }
}