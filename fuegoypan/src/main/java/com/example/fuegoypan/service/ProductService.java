package com.example.fuegoypan.service;

import com.example.fuegoypan.dto.ProductDTO;
import com.example.fuegoypan.dto.ProductCreateDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductDTO createProduct(ProductCreateDTO dto);

    ProductDTO updateProduct(Long id, ProductCreateDTO dto);

    List<ProductDTO> getAll();

    ProductDTO getById(Long id);

    Optional<ProductDTO> getEntityById(Long id);

}