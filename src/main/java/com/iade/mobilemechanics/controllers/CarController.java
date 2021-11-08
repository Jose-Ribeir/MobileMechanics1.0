package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Car;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.CarRepository;
import com.iade.mobilemechanics.models.repositories.ClientRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/cars")
public class CarController {
    private final Logger logger = LoggerFactory.getLogger(CarController.class);
    @Autowired

    private CarRepository carRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Car> getCars(){
        logger.info("Send all cars to Request");
        return carRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car getCar(@PathVariable int id){
        logger.info("Send car with id "+ id + "to Request");
        Optional<Car> _car = carRepository.findById(id);
        if (!_car.isPresent()) throw
                new NotFoundException("" + id, "Car", "id");
        else
            return _car.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car saveCar(@RequestBody Car car){
        Car savedCar = carRepository.save(car);
        logger.info("Save car id " + savedCar.getId() + " to Database");
        return savedCar;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteCar(@PathVariable int id){
        logger.info("Delete car with id "+ id + "to Request");
        Optional<Car> _car = carRepository.findById(id);
        if (!_car.isPresent()) throw
                new NotFoundException("" + id, "Car", "id");
        else{
            carRepository.deleteById(id);
            return "Deleted";}
    }

    @GetMapping(path = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Car> getCarByClientId(@PathVariable int id){
        Optional<Car> _car = carRepository.findById(id);
        if (!_car.isPresent()) throw
                new NotFoundException("" + id, "Car", "id");
        else
            return carRepository.findCarByCarClientId(id);
    }
}
