package com.example.fuegoypan.repository;

import com.example.fuegoypan.model.SaleLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleLineRepo extends JpaRepository<SaleLine, Long> {
}