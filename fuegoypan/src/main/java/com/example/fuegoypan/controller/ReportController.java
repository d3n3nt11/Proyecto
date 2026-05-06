package com.example.fuegoypan.controller;

import com.example.fuegoypan.dto.SaleDTO;
import com.example.fuegoypan.dto.StockMovementDTO;
import com.example.fuegoypan.model.Sale;
import com.example.fuegoypan.service.ReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    // Constructor manual (reemplaza @RequiredArgsConstructor)
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/sales/csv")
    public ResponseEntity<byte[]> downloadSalesCsv(
            @RequestParam String start,
            @RequestParam String end
    ) {

        byte[] data = reportService.generateSalesCsv(start, end);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ventas.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(data);
    }

    @GetMapping("/stock-movements/csv")
    public ResponseEntity<byte[]> downloadStockMovementsCsv(
            @RequestParam String start,
            @RequestParam String end
    ) {

        byte[] data = reportService.generateStockMovementsCsv(start, end);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=stock_movements.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(data);
    }
    // Endpoint que devuelve JSON para visualizar en la app
    @GetMapping("/sales")
    public ResponseEntity<List<SaleDTO>> getSalesReport(
            @RequestParam String start,
            @RequestParam String end) {

        // LLAMAR AL SERVICE, no al repository directamente
        List<SaleDTO> dtos = reportService.getSalesReport(start, end);

        return ResponseEntity.ok(dtos);
    }
    // Endpoint JSON para visualizar consumo de ingredientes
    @GetMapping("/ingredientes-consumidos")
    public ResponseEntity<List<StockMovementDTO>> getIngredientConsumption(
            @RequestParam String start,
            @RequestParam String end) {

        List<StockMovementDTO> dtos = reportService.getIngredientConsumptionReport(start, end);
        return ResponseEntity.ok(dtos);
    }
    // Endpoint JSON para visualizar movimientos de stock
    @GetMapping("/stock-movimientos")
    public ResponseEntity<List<StockMovementDTO>> getStockMovements(
            @RequestParam String start,
            @RequestParam String end) {

        List<StockMovementDTO> dtos = reportService.getStockMovementsReport(start, end);
        return ResponseEntity.ok(dtos);
    }
}