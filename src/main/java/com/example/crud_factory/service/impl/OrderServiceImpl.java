package com.example.crud_factory.service.impl;

import com.example.crud_factory.service.CashOnDelivery;
import com.example.crud_factory.service.OrderService;
import com.example.crud_factory.service.PaymentService;
import com.example.crud_factory.service.StripePayment;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final Map<String, PaymentService> paymentService;

    public OrderServiceImpl(Map<String, PaymentService> payment) {
        this.paymentService = payment;
    }

    @Override
    public void placeOrder(String beanName) {
        paymentService.get(beanName).processPayment(10);
    }
}
