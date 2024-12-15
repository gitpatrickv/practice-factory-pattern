package com.example.crud_factory.controller;

import com.example.crud_factory.dto.Model;
import com.example.crud_factory.dto.constants.ResponseCode;
import com.example.crud_factory.dto.response.Response;
import com.example.crud_factory.service.CrudService;


import com.example.crud_factory.service.factory.CrudServiceFactory;
import com.example.crud_factory.service.factory.Module;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
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

    @GetMapping("/{module}/{id}")
    public ResponseEntity<Model> getOne(@PathVariable Module module,@PathVariable String id){
        CrudService service = getService(module);
        Response resp = service.retrieve(id);
        log.info("CrudService.retrieve() response code={}", resp.getResponseCode());
        Model responseObject = (Model) resp.getResponseObject();
        log.info("GET Response: 200 - Found record for id={}, returning {}", id, responseObject);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
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
