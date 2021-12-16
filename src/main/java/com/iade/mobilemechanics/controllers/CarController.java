package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.*;
import com.iade.mobilemechanics.models.repositories.*;
import com.iade.mobilemechanics.models.request.CarRequest;
import com.iade.mobilemechanics.models.exceptions.AlreadyExistsException;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;

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
    private BrandRepository brandRepository;
    private ModelRepository modelRepository;
    private EngineRepository engineRepository;
    private ClientRepository clientRepository;


    public CarController(BrandRepository brandRepository, ModelRepository modelRepository, EngineRepository engineRepository, ClientRepository clientRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.engineRepository = engineRepository;
        this.clientRepository = clientRepository;
    }

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
    public Car saveCar(@RequestBody CarRequest car) {
        Optional<Car> _Car = carRepository.findCarLicensePlateByCarLicensePlate(car.getCarLicensePlate());
        if (_Car.isPresent()) {
            throw new AlreadyExistsException(car.getCarLicensePlate());
        }

        Optional<Brand> brand = brandRepository.findById(car.getCarBrandId());
        Optional<Model> model = modelRepository.findById(car.getCarModelId());
        Optional<Engine> engine = engineRepository.findById(car.getCarEngineId());
        Optional<Client> client = clientRepository.findById(car.getCarClientId());

        Car car1 = new Car();
        car1.setCarBrand(brand.get());
        car1.setCarModel(model.get());
        car1.setCarEngine(engine.get());
        car1.setCarClient(client.get());
        car1.setCarYear(car.getCarYear());
        car1.setCarLicensePlate(car.getCarLicensePlate());
        car1.setCarFuel(car.getCarFuel());
        car1.setCarTransmission(car.getCarTransmission());

        Car saveCar = carRepository.save(car1);
        logger.info("Save Car id " + saveCar.getId() + " to Database");

        return saveCar;
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
            return carRepository.findByCarClientId(id);
    }
}
