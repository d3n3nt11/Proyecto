package com.example.fuegoypan.controller;

import com.example.fuegoypan.service.ReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}