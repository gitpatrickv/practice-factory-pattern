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
    public ResponseEntity<Model> save(@PathVariable Module module, @RequestBody String jsonRequest){
        CrudService service = getService(module);
        Response response = service.create(jsonRequest);
        log.info("CrudService.create() response code={}", response.getResponseCode());

        if(response.getResponseCode().equals(ResponseCode.RESP_SUCCESS)) {
            log.info("POST Response 201 - {}", response.getResponseDescription());
            Model models = (Model) response.getResponseObject();
            return new ResponseEntity<>(models, HttpStatus.CREATED);
        }else {
            log.error("POST Response: 500 - Internal server error (failed to execute request)");
            throw new RuntimeException("An unexpected error occurred while processing the POST request.");
        }
    }

    @GetMapping("/{module}/{id}")
    public ResponseEntity<Model> getOne(@PathVariable Module module,@PathVariable String id){
        CrudService service = getService(module);
        Response response = service.retrieve(id);
        log.info("CrudService.retrieve() response code={}", response.getResponseCode());
        if(response.getResponseCode().equals(ResponseCode.RESP_SUCCESS)) {
            Model responseObject = (Model) response.getResponseObject();
            log.info("GET Response: 200 - {}, returning {}", response.getResponseDescription(), responseObject);
            return new ResponseEntity<>(responseObject, HttpStatus.OK);
        } else if (response.getResponseCode().equals(ResponseCode.RESP_NOT_FOUND)){
            log.warn("GET Response: 404 - {}", response.getResponseDescription());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else {
            log.error("GET Response: 500 - Internal server error (failed to execute request)");
            throw new RuntimeException("An unexpected error occurred while processing the GET request.");
        }
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
