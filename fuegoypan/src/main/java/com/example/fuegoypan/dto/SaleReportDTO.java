package com.example.fuegoypan.dto;

import java.time.LocalDateTime;

public class SaleReportDTO {

    private Long id;
    private LocalDateTime date;
    private Double total;
    private String status;
    private String userName;

    public SaleReportDTO(Long id, LocalDateTime date, Double total, String status, String userName) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.status = status;
        this.userName = userName;
    }

    // getters

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public String getUserName() {
        return userName;
    }
}