package com.example.crud_factory.service.strategy;

import org.springframework.stereotype.Service;

@Service
public class PaypalPayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("PAYPAL PAYMENT");
        System.out.println(amount);
    }
}
