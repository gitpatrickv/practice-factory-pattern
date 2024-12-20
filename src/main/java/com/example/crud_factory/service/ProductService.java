package com.example.crud_factory.service;

import com.example.crud_factory.entity.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(String id);
}
