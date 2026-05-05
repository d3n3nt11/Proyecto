package com.example.fuegoypan.controller;

import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;

import com.example.fuegoypan.model.Sale;
import com.example.fuegoypan.repository.SaleRepo;
import com.example.fuegoypan.service.SaleService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/stripe")
public class StripeController {

    private final SaleRepo saleRepo;
    private final SaleService saleService;

    @Value("${stripe.webhook.secret}")
    private String webhookSecret;

    public StripeController(SaleRepo saleRepo, SaleService saleService) {
        this.saleRepo = saleRepo;
        this.saleService = saleService;
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> handleStripeEvent(
            @RequestBody String payload,
            @RequestHeader("Stripe-Signature") String sigHeader) {

        Event event;

        try {
            event = Webhook.constructEvent(payload, sigHeader, webhookSecret);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        //  SOLO CUANDO EL PAGO SE COMPLETA
        if ("checkout.session.completed".equals(event.getType())) {

            EventDataObjectDeserializer deserializer = event.getDataObjectDeserializer();

            if (deserializer.getObject().isPresent()) {

                Object obj = deserializer.getObject().get();

                if (obj instanceof Session session) {

                    String sessionId = session.getId();

                    Sale sale = saleRepo.findByStripeSessionId(sessionId)
                            .orElseThrow();

                    saleService.updateStatus(sale.getId(), "PAID");
                }
            }
        }

        return ResponseEntity.ok("ok");
    }
}