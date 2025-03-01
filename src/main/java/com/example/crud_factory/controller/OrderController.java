package com.example.crud_factory.controller;

import com.example.crud_factory.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{beanName}")
    public void placeOrder(@PathVariable String beanName) {
        orderService.placeOrder(beanName);
    }
}
