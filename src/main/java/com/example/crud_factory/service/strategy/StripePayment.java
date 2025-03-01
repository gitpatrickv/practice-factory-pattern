package com.example.crud_factory.service.strategy;

import org.springframework.stereotype.Service;

@Service
public class StripePayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("STRIPE PAYMENT");
        System.out.println(amount);
    }
}
