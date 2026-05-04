package com.example.fuegoypan.repository;

import com.example.fuegoypan.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    // List<Product> findByVisibleTrue();
}