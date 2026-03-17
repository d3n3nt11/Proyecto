package com.example.fuegoypan.service.impl;

import com.example.fuegoypan.dto.ProductDTO;
import com.example.fuegoypan.dto.ProductCreateDTO;
import com.example.fuegoypan.model.Product;
import com.example.fuegoypan.repository.ProductRepo;
import com.example.fuegoypan.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public ProductDTO createProduct(ProductCreateDTO dto) {
        Product product = Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .visible(dto.getVisible())
                .build();

        Product saved = productRepo.save(product);
        return mapToDTO(saved);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductCreateDTO dto) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setVisible(dto.getVisible());

        Product saved = productRepo.save(product);
        return mapToDTO(saved);
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Long id) {
        return productRepo.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
    }

    @Override
    public Optional<ProductDTO> getEntityById(Long id) {
        return productRepo.findById(id).map(this::mapToDTO);
    }

    private ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setVisible(product.getVisible());
        return dto;
    }
}