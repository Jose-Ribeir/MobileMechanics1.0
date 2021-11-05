package com.iade.mobilemechanics.controllers;


import com.iade.mobilemechanics.models.Car;
import com.iade.mobilemechanics.models.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/hello")
public class Hello {
    @Autowired
    private CarRepository carRepository;
    @GetMapping(path = "/h", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Car> getcar(){
        return carRepository.findAll();
    }
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCars(){
        return "hello3";
    }
    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCars2(){
        return "hello2";
    }
}

