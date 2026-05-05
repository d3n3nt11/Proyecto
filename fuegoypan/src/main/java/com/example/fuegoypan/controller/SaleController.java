package com.example.fuegoypan.controller;

import com.example.fuegoypan.dto.SaleCreateDTO;
import com.example.fuegoypan.dto.SaleDTO;
import com.example.fuegoypan.dto.StatusRequest;
import com.example.fuegoypan.model.Sale;
import com.example.fuegoypan.model.SaleStatus;
import com.example.fuegoypan.repository.SaleRepo;
import com.example.fuegoypan.service.SaleService;
import com.example.fuegoypan.service.StripeService;
import com.stripe.model.checkout.Session;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;
    private final SaleRepo saleRepo;
    private final StripeService stripeService;

    public SaleController(SaleService saleService, SaleRepo saleRepo, StripeService stripeService) {
        this.saleService = saleService;
        this.saleRepo = saleRepo;
        this.stripeService = stripeService;
    }

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(
            @Valid @RequestBody SaleCreateDTO dto,
            Authentication authentication) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saleService.createSale(dto, authentication));
    }
    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAll() {
        return ResponseEntity.ok(saleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getById(id));
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<Map<String, String>> pay(@PathVariable Long id) throws Exception {

        Sale sale = saleRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Venta no encontrada"));

        if (sale.getStatus() != SaleStatus.OPEN) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "La venta no está abierta");
        }

        Session session = stripeService.createCheckoutSession(sale);

        // guardar sesión en la venta
        sale.setStripeSessionId(session.getId());
        saleRepo.save(sale);

        return ResponseEntity.ok(Map.of("url", session.getUrl()));
    }

    // CAMBIAR ESTADO
    @PatchMapping("/{id}/status")
    public ResponseEntity<SaleDTO> updateStatus(
            @PathVariable Long id,
            @RequestBody StatusRequest request) {

        return ResponseEntity.ok(
                saleService.updateStatus(id, request.getStatus())
        );
    }

    // CANCELAR
    @PatchMapping("/{id}/cancel")
    public ResponseEntity<SaleDTO> cancelSale(@PathVariable Long id) {
        return ResponseEntity.ok(
                saleService.cancelSale(id)
        );
    }
}