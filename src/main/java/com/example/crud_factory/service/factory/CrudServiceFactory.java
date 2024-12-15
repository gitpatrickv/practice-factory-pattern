package com.example.crud_factory.service.factory;

import com.example.crud_factory.service.CrudService;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;


public class CrudServiceFactory {

    private final ApplicationContext applicationContext;

    public CrudServiceFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public CrudService getService(Module module){
        String beanName = Arrays.stream(Module.values())
                .filter(mod -> mod.equals(module))
                .iterator()
                .next()
                .getBeanName();

        return (CrudService) applicationContext.getBean(beanName);
    }

}
