package com.example.crud_factory.service.strategy;

import com.example.crud_factory.entity.PaymentMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final Map<String, PaymentService> paymentService;

    public OrderServiceImpl(Map<String, PaymentService> payment) {
        this.paymentService = payment;
    }

    @Override
    public void placeOrder(PaymentMethod paymentMethod) {
        String beanName = paymentMethod.getBeanName();
        paymentService.get(beanName).processPayment(10);
    }
}
