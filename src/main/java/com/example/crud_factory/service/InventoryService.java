package com.example.crud_factory.service;

public class InventoryService extends CrudService{

    @Override
    protected String save() {
        return "Save Inventory";
    }

    @Override
    protected String update() {
        return "Update Inventory";
    }

    @Override
    protected String delete() {
        return "Delete Inventory";
    }

    @Override
    protected String getOne() {
        return "Get One Inventory";
    }
}
