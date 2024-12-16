package com.example.crud_factory.service.factory;

public enum Module {
    product("productService", "product"),
    post("postService", "post");

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
