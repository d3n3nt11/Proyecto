package com.example.fuegoypan.dto;


public class SaleLineCreateDTO {
    private Long productId;
    private Integer quantity;

    public SaleLineCreateDTO() {
    }

    public SaleLineCreateDTO(Integer quantity, Long productId) {
        this.quantity = quantity;
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}