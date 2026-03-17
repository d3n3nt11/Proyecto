package com.example.fuegoypan.repository;

import com.example.fuegoypan.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    // List<Product> findByVisibleTrue();
}