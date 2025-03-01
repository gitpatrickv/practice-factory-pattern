package com.example.crud_factory.service;

import com.example.crud_factory.entity.PaymentMethod;

public interface OrderService {
    void placeOrder(PaymentMethod paymentMethod);
}
