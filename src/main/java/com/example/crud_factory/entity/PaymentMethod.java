package com.example.crud_factory.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentMethod {
    STRIPE_PAYMENT("stripePayment"),
    PAYPAL_PAYMENT("paypalPayment"),
    CASH_ON_DELIVERY("cashOnDelivery");

    private final String beanName;
}
