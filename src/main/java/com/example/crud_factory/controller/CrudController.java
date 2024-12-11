package com.example.crud_factory.controller;

import com.example.crud_factory.service.CrudService;
import com.example.crud_factory.service.CrudServiceFactory;
import com.example.crud_factory.service.Module;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CrudController {

    private final CrudServiceFactory serviceFactory;

    public CrudController(CrudServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @PostMapping("/{module}")
    public ResponseEntity<String> save(@PathVariable Module module){
        CrudService service = getService(module);
        return new ResponseEntity<>(service.create(), HttpStatus.CREATED);
    }

    @GetMapping("/{module}")
    public ResponseEntity<String> getOne(@PathVariable Module module){
        CrudService service = getService(module);
        return new ResponseEntity<>(service.retrieve(), HttpStatus.OK);
    }

    @PutMapping("/{module}")
    public ResponseEntity<String> update(@PathVariable Module module){
        CrudService service = getService(module);
        return new ResponseEntity<>(service.updateOne(), HttpStatus.OK);
    }

    @DeleteMapping("/{module}")
    public ResponseEntity<String> delete(@PathVariable Module module){
        CrudService service = getService(module);
        return new ResponseEntity<>(service.deleteOne(), HttpStatus.OK);
    }

    private CrudService getService(Module module) {
        return serviceFactory.getService(module);
    }
}
