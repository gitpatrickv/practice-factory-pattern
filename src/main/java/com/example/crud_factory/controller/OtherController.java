package com.example.crud_factory.controller;

import com.example.crud_factory.service.OtherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OtherController {

    private final OtherService otherService;
    Logger log = LoggerFactory.getLogger(OtherController.class);
    public OtherController(OtherService otherService){
        this.otherService = otherService;
    }

    @GetMapping()
    public ResponseEntity<String> getOtherService(){
        String result = otherService.otherMethod();
        log.info(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> newMethod(){
        String result = otherService.newMethod();
        log.info(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
