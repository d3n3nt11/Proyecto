package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.dto.SaleDTO;
import com.example.fuegoypan.dto.StockMovementDTO;
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

    // VENTAS CSV
    @Override
    public byte[] generateSalesCsv(String start, String end) {
        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(end).atTime(23, 59, 59);

        List<Sale> sales = saleRepository.findSalesBetween(startDate, endDate);
        StringBuilder csv = new StringBuilder();
        csv.append("\uFEFF"); // BOM UTF-8

        csv.append("ID;Fecha;Total;Estado;Camarero\n");

        for (Sale s : sales) {
            csv.append(s.getId()).append(";");
            csv.append(s.getDate() != null ? s.getDate().toString().replace("T", " ") : "").append(";");
            csv.append(s.getTotal()).append(";");
            csv.append(s.getStatus()).append(";");
            //  Aquí sacamos el NOMBRE del usuario, no el ID
            csv.append(s.getUser() != null ? s.getUser().getName() : "Desconocido").append("\n");
        }

        return csv.toString().getBytes(StandardCharsets.UTF_8);
    }

    // STOCK MOVEMENTS CSV
    @Override
    public byte[] generateStockMovementsCsv(String start, String end) {
        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(end).atTime(23, 59, 59);

        List<StockMovement> movements = stockMovementRepo.findByCreatedAtBetween(startDate, endDate);
        StringBuilder csv = new StringBuilder();
        csv.append("\uFEFF"); // BOM UTF-8
        csv.append("ID;Ingrediente;Unidad;Cantidad;Tipo;Fecha;VentaID\n");
        for (StockMovement m : movements) {
            csv.append(m.getId()).append(";");
            csv.append(m.getIngredient() != null ? m.getIngredient().getName() : "N/A").append(";");

            csv.append(m.getIngredient() != null ? m.getIngredient().getUnit() : "N/A").append(";");

            csv.append(m.getQuantity()).append(";");
            csv.append(m.getType()).append(";");
            csv.append(m.getCreatedAt() != null ? m.getCreatedAt().toString().replace("T", " ") : "").append(";");
            csv.append(m.getSale() != null ? m.getSale().getId() : "").append("\n");
        }

        return csv.toString().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public List<SaleDTO> getSalesReport(String start, String end) {
        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(end).atTime(23, 59, 59);

        List<Sale> sales = saleRepository.findSalesBetween(startDate, endDate);

        return sales.stream().map(s -> {
            SaleDTO dto = new SaleDTO();
            dto.setId(s.getId());
            dto.setDate(s.getDate());
            dto.setTotal(s.getTotal());
            dto.setStatus(s.getStatus());
            dto.setUserId(s.getUser() != null ? s.getUser().getId() : null);
            dto.setUserName(s.getUser() != null ? s.getUser().getName() : "Desconocido"); // 👈 NUEVO
            return dto;
        }).toList();
    }
// CONSUMO DE INGREDIENTES (JSON)
    @Override
    public List<StockMovementDTO> getIngredientConsumptionReport(String start, String end) {
        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(end).atTime(23, 59, 59);

        // Obtenemos todos los movimientos en el rango de fechas
        List<StockMovement> movements = stockMovementRepo.findByCreatedAtBetween(startDate, endDate);

        // Mapeamos a DTO para enviar al frontend
        return movements.stream().map(m -> {
            StockMovementDTO dto = new StockMovementDTO();
            dto.setIngredientId(m.getIngredient() != null ? m.getIngredient().getId() : null);
            dto.setIngredientName(m.getIngredient() != null ? m.getIngredient().getName() : "N/A"); // 👈 NUEVO
            dto.setQuantity(m.getQuantity());
            dto.setType(m.getType());
            dto.setSaleId(m.getSale() != null ? m.getSale().getId() : null);
            dto.setUnit(m.getIngredient() != null ? m.getIngredient().getUnit() : "uds");

            return dto;
        }).toList();
    }
// MOVIMIENTOS DE STOCK (JSON)
    @Override
    public List<StockMovementDTO> getStockMovementsReport(String start, String end) {
        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(end).atTime(23, 59, 59);

        List<StockMovement> movements = stockMovementRepo.findByCreatedAtBetween(startDate, endDate);

        // En getStockMovementsReport():
        return movements.stream().map(m -> {
            StockMovementDTO dto = new StockMovementDTO();
            dto.setIngredientId(m.getIngredient() != null ? m.getIngredient().getId() : null);
            dto.setIngredientName(m.getIngredient() != null ? m.getIngredient().getName() : "N/A");
            dto.setQuantity(m.getQuantity());

            dto.setUnit(m.getIngredient() != null ? m.getIngredient().getUnit() : "uds");

            dto.setType(m.getType());
            dto.setSaleId(m.getSale() != null ? m.getSale().getId() : null);
            return dto;
        }).toList();

    }
}