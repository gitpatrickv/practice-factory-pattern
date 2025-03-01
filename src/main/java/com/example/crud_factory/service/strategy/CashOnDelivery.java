package com.example.crud_factory.service.strategy;

import org.springframework.stereotype.Service;

@Service
public class CashOnDelivery implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("CASH ON DELIVERY");
        System.out.println(amount);
    }
}
