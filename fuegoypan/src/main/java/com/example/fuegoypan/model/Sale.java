package com.example.fuegoypan.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime date; // fecha de la venta

    private Double total;

    @Enumerated(EnumType.STRING) // guardar como texto en la DB
    @Column(nullable = false)
    private SaleStatus status; // enum

    // El usuario que hace la venta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // Líneas de venta
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SaleLine> lines = new ArrayList<>();

    // ===== CONSTRUCTORES =====

    public Sale() {
    }

    // Constructor con todos los atributos
    public Sale(Long id, LocalDateTime date, Double total, SaleStatus status, User user, List<SaleLine> lines) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.status = status;
        this.user = user;
        this.lines = lines;
    }

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getTotal() {
        return total;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public List<SaleLine> getLines() {
        return lines;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLines(List<SaleLine> lines) {
        this.lines = lines;
    }
}