package com.example.crud_factory.service;

public class ItemService  extends CrudService implements OtherService{


    @Override
    protected String save() {
        return "Save Item";
    }

    @Override
    protected String update() {
        return "Update Item";
    }

    @Override
    protected String delete() {
        return "Delete Item";
    }

    @Override
    protected String getOne() {
        return "Get One Item";
    }
    @Override
    protected String moduleName(){
        return Module.item.getModuleName();
    }

    @Override
    public String otherMethod() {
        return "Other Method";
    }
}
