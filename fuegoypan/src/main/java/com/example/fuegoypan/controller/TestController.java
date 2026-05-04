// src/main/java/com/example/fuegoypan/controller/TestController.java
package com.example.fuegoypan.controller;

import com.example.fuegoypan.model.Product;
import com.example.fuegoypan.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired private ProductRepo productRepo;

    @GetMapping("/health")
    public String health() {
        return "✅ Conectado a MariaDB Cloud - FuegoyPan";
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}