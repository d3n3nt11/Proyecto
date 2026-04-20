package com.example.fuegoypan.controller;

import com.example.fuegoypan.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

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
}