package com.example.fuegoypan.repository;

import com.example.fuegoypan.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Long> {
    @Query("""
    SELECT s FROM Sale s
    JOIN FETCH s.user
    WHERE s.date BETWEEN :start AND :end
    """)
    List<Sale> findSalesBetween(LocalDateTime start, LocalDateTime end);

    Optional<Sale> findByStripeSessionId(String sessionId);
}