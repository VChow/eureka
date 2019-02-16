package com.example.eureka.discoveryclient.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello from " + port, HttpStatus.OK);
    }
}
