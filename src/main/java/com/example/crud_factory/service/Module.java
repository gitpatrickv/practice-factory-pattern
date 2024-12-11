package com.example.crud_factory.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@Getter
//@AllArgsConstructor
public enum Module {
    inventory("inventoryService", "inventory"),
    product("productService", "product"),
    variation("variationService", "variation");

    private final String beanName;
    private final String moduleName;

    public String getBeanName() {
        return this.beanName;
    }

    public String getModuleName() {
        return this.moduleName;
    }
    private Module(String beanName, String moduleName){
        this.beanName = beanName;
        this.moduleName = moduleName;
    }

}
