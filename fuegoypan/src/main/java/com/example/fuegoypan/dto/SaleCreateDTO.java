package com.example.fuegoypan.dto;

import com.example.fuegoypan.model.SaleStatus;


import java.util.List;

public class SaleCreateDTO {
    private Long userId;
    private List<SaleLineCreateDTO> lines;
    private SaleStatus status; // OPEN, CLOSED, etc.

    public SaleCreateDTO() {
    }

    public SaleCreateDTO(Long userId, List<SaleLineCreateDTO> lines, SaleStatus status) {
        this.userId = userId;
        this.lines = lines;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public List<SaleLineCreateDTO> getLines() {
        return lines;
    }

    public void setLines(List<SaleLineCreateDTO> lines) {
        this.lines = lines;
    }
}