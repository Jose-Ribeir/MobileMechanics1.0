package com.iade.mobilemechanics.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cars")
public class CarController {
    @GetMapping(path = "/hello",produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayhello(){
        return "hello jaimie";
    }
    @GetMapping(path = "/goodbye",produces = MediaType.APPLICATION_JSON_VALUE)
    public String saygoodbye(){
        return "bye jaimie";

    }
}
