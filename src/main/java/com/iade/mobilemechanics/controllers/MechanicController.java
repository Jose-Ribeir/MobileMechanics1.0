package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Client;
import com.iade.mobilemechanics.models.Mechanic;
import com.iade.mobilemechanics.models.repositories.ClientRepository;
import com.iade.mobilemechanics.models.repositories.MechanicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/mechanics")
public class MechanicController {
    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private MechanicRepository mechanicRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Mechanic> getMechanic(){
        logger.info("Send all Mechanics to Request");
        return mechanicRepository.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Mechanic> getMechanic(@PathVariable int id){
        logger.info("Send Mechanic with id "+ id + "to Request");
        return mechanicRepository.findById(id);
    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mechanic savedMechanic(@RequestBody Mechanic mechanic){
        Mechanic savedMechanic = mechanicRepository.save(mechanic);
        logger.info("Save Client id " + savedMechanic.getId() + " to Database");
        return savedMechanic;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteMechanic(@PathVariable int id){
        logger.info("Delete Mechanic with id "+ id + "to Request");
        mechanicRepository.deleteById(id);
        return "Deleted";
    }
}
