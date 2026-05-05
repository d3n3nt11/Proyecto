package com.example.fuegoypan.service;

import com.example.fuegoypan.model.Sale;
import com.example.fuegoypan.model.SaleLine;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    @Value("${stripe.secret.key}")
    private String stripeKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeKey;
    }

    public Session createCheckoutSession(Sale sale) throws Exception {

        SessionCreateParams.Builder builder =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl("http://localhost:5173/success?session_id={CHECKOUT_SESSION_ID}")
                        .setCancelUrl("http://localhost:5173/cancel");

        //  Añadir líneas reales
        for (SaleLine line : sale.getLines()) {

            builder.addLineItem(
                    SessionCreateParams.LineItem.builder()
                            .setQuantity(line.getQuantity().longValue())
                            .setPriceData(
                                    SessionCreateParams.LineItem.PriceData.builder()
                                            .setCurrency("eur")
                                            .setUnitAmount((long)(line.getUnitPrice() * 100))
                                            .setProductData(
                                                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                            .setName(line.getProduct().getName())
                                                            .build()
                                            )
                                            .build()
                            )
                            .build()
            );
        }

        Session session = Session.create(builder.build());

        return session;
    }
}