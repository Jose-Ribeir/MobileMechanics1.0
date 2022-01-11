package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.*;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.*;
import com.iade.mobilemechanics.models.request.LocationRequest;
import com.iade.mobilemechanics.models.request.RepairDateRequest;
import com.iade.mobilemechanics.models.request.RepairRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/repairs")
public class RepairController {
    private final Logger logger = LoggerFactory.getLogger(RepairController.class);

    @Autowired
    private RepairRepository repairRepository;
    private CarRepository carRepository;
    private MechanicRepository mechanicRepository;

    public RepairController(CarRepository carRepository, MechanicRepository mechanicRepository) {
        this.carRepository = carRepository;
        this.mechanicRepository = mechanicRepository;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Repair> getRepairs() {
        logger.info("Send all Repairs to Request");
        return repairRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Repair getRepair(@PathVariable int id) {
        logger.info("Send Repair with id " + id + "to Request");
        Optional<Repair> _repair = repairRepository.findById(id);
        if (!_repair.isPresent()) throw
                new NotFoundException("" + id, "Repair", "id");
        else
            return _repair.get();

    }

   // @GetMapping(path = "car/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //    public Iterable<Repair> getRepairbyCarid(@PathVariable int id) {
    //        logger.info("Send Repair with id " + id + "to Request");
    //        Iterable<Repair> _repair = repairRepository.findByRepairCarId(id);
    //
    //
    //        return _repair;
    //
    //    }


    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Repair saveRepair(@RequestBody RepairRequest repair) {

        Optional<Car> car = carRepository.findById(repair.getRepairCar());
       // Optional<Mechanic> mechanic = mechanicRepository.findById(repair.getReepairMechanic());


        Repair repair1 = new Repair();
        repair1.setRepairCar(car.get());
        //repair1.setRepairMechanic(mechanic.get());
        //repair1.setRepairDate(repair.getRepairDate());

        Repair repairsave = repairRepository.save(repair1);
        repairsave.setRepairCompleted(false);
        repairsave.setRepairTaken(false);
        logger.info("Save Repair id " + repairsave.getId() + " to Database");

        return repairsave;
    }

    @PostMapping(path = "/post/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Repair putlocation(@RequestBody LocationRequest repair, @PathVariable int id) {

        Optional<Repair> reparacao = repairRepository.findById(id);


        Repair repair1 = new Repair();
        repair1 = reparacao.get();
        repair1.setRepairLat(repair.getRepairLat());
        repair1.setRepairLong(repair.getRepairLong());
        //repair1.setId(reparacao.get);
        final Repair updatedEmployee = repairRepository.save(repair1);

        logger.info("Save Repair id " + repair1.getId() + " to Database");
        return repair1;
    }

    @PostMapping(path = "/data/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Repair putdata(@RequestBody RepairDateRequest repair, @PathVariable int id) {


        Optional<Repair> reparacao = repairRepository.findById(id);


        Repair repair1 = new Repair();
        repair1 = reparacao.get();
        repair1.setRepairDate(repair.getRepairDate());
        //repair1.setId(reparacao.get);
        final Repair updatedEmployee = repairRepository.save(repair1);

        logger.info("Save Repair id " + repair1.getId() + " to Database");
        return repair1;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteRepair(@PathVariable int id) {
        logger.info("Delete Repair with id " + id + "to Request");
        Optional<Repair> _repair = repairRepository.findById(id);
        if (!_repair.isPresent()) throw
                new NotFoundException("" + id, "Repair", "id");
        else{
            repairRepository.deleteById(id);
            return "Deleted";}
    }

    @GetMapping(path = "/car/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Repair> getRepairByCarId(@PathVariable int id){
        return repairRepository.findByRepairCarId(id);
    }



}
