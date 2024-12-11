package com.example.crud_factory.service;

public class ProductService extends CrudService{
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
    protected String getOne() {
        return "Get One Product";
    }
}
