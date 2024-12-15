package com.example.crud_factory.service.impl;

import com.example.crud_factory.dto.ProductModel;
import com.example.crud_factory.entity.Product;
import com.example.crud_factory.repository.ProductRepository;
import com.example.crud_factory.service.CrudService;
import com.example.crud_factory.service.factory.Module;
import com.example.crud_factory.util.Mapper;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductServiceImpl extends CrudService {

    private final ProductRepository productRepository;
    private final Mapper mapper;

    @Override
    protected String save() {
        return "Save Product";
    }
    @Override
    protected String update() {
        return "Update Product";
    }

    @Override
    protected String delete() {
        return "Delete Product";
    }

    @Override
    protected ProductModel getOne(String id) {
        Optional<Product>product = productRepository.findById(Integer.parseInt(id));
        return mapper.mapEntityToModel(product.get(), ProductModel.class);
    }

    @Override
    protected String moduleName(){
        return Module.product.getModuleName();
    }

}
