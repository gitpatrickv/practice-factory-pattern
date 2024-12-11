package com.example.crud_factory.config;

import com.example.crud_factory.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServiceConfiguration {

    private final ApplicationContext applicationContext;

    public ServiceConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public CrudServiceFactory getServiceFactory() {
        return new CrudServiceFactory(applicationContext);
    }

    @Bean (name = "inventoryService")
    public InventoryService getInventoryService(){
        return new InventoryService();
    }

    @Bean (name = "productService")
    public ProductService getProductService(){
        return new ProductService();
    }

    @Bean (name = "variationService")
    public VariationService getVariationService(){
        return new VariationService();
    }

    @Bean (name = "itemService")
    public ItemService getItemService(){
        return new ItemService();
    }
}
