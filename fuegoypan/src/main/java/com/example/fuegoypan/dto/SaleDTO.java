package com.example.fuegoypan.dto;

import com.example.fuegoypan.model.SaleStatus;

import java.time.LocalDateTime;
import java.util.List;


public class SaleDTO {
    private Long id;
    private LocalDateTime date;
    private Double total;
    private SaleStatus status;
    private Long userId;
    private List<SaleLineDTO> lines;

    public SaleDTO() {
    }

    public SaleDTO(Long id, LocalDateTime date, Double total, SaleStatus status, Long userId, List<SaleLineDTO> lines) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.status = status;
        this.userId = userId;
        this.lines = lines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<SaleLineDTO> getLines() {
        return lines;
    }

    public void setLines(List<SaleLineDTO> lines) {
        this.lines = lines;
    }
}