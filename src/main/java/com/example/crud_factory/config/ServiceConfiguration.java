package com.example.crud_factory.config;

import com.example.crud_factory.repository.PostRepository;
import com.example.crud_factory.repository.ProductRepository;
import com.example.crud_factory.service.impl.PostServiceImpl;
import com.example.crud_factory.util.Mapper;
import com.example.crud_factory.service.factory.CrudServiceFactory;
import com.example.crud_factory.service.impl.ProductServiceImpl;
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

    @Bean (name = "productService")
    public ProductServiceImpl getProductService(ProductRepository repository, Mapper mapper){
        return new ProductServiceImpl(repository, mapper);
    }

    @Bean (name = "postService")
    public PostServiceImpl getPostService (PostRepository repository, Mapper mapper){
        return new PostServiceImpl(repository, mapper);
    }


}
