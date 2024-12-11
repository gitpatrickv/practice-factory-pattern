package com.example.crud_factory.service;

public class VariationService extends CrudService{

    @Override
    protected String save() {
        return "Save Variation";
    }

    @Override
    protected String update() {
        return "Update Variation";
    }

    @Override
    protected String delete() {
        return "Delete Variation";
    }

    @Override
    protected String getOne() {
        return "Get One Variation";
    }

    @Override
    protected String moduleName(){
        return Module.variation.getModuleName();
    }
}
