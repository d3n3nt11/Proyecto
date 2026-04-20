package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.model.Sale;
import com.example.fuegoypan.repository.SaleRepo;
import com.example.fuegoypan.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final SaleRepo saleRepository;

    @Override
    public byte[] generateSalesCsv(String start, String end) {

        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(end).atTime(23, 59, 59);

        List<Sale> sales = saleRepository.findSalesBetween(startDate, endDate);

        StringBuilder csv = new StringBuilder();

        // cabecera
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
}