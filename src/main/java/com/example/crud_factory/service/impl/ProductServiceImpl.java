package com.example.crud_factory.service.impl;

import com.example.crud_factory.dto.Model;
import com.example.crud_factory.dto.ProductModel;
import com.example.crud_factory.entity.Product;
import com.example.crud_factory.repository.ProductRepository;
import com.example.crud_factory.service.CrudService;
import com.example.crud_factory.service.ProductService;
import com.example.crud_factory.service.factory.Module;
import com.example.crud_factory.util.EntityToModelMapper;
import com.example.crud_factory.util.ModelToEntityMapper;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductServiceImpl extends CrudService implements ProductService {

    private final ProductRepository productRepository;
//    private final Mapper mapper;
    private final Validator validator;

    private ModelToEntityMapper<ProductModel, Product> modelToEntityMapper = new ModelToEntityMapper<>(Product.class);
    private EntityToModelMapper<Product, ProductModel> entityToModelMapper = new EntityToModelMapper<>(ProductModel.class);

    @Override
    protected <T extends Model> Model save(T model) {
        Product product = modelToEntityMapper.map((ProductModel) model);
        product.setTimestamp(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        return entityToModelMapper.map(savedProduct);
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
    protected List<ProductModel> getAll() {
        return productRepository.findAll()
                .stream()
                .map((product) -> entityToModelMapper.map(product))
                .toList();
    }

    @Override
    protected ProductModel getOne(String id) {
        Optional<Product> optionalProduct = this.getProductById(id);
        return optionalProduct.map(product -> entityToModelMapper.map(product))
                .orElse(null);
    }

    @Override
    protected String moduleName(){
        return Module.product.getModuleName();
    }

    @Override
    protected Class modelClass() {
        return ProductModel.class;
    }

    @Override
    protected Validator validator() {
        return validator;
    }


    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(Integer.parseInt(id));
    }
}
