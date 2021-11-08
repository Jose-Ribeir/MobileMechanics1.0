package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Mechanic;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
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
    private final Logger logger = LoggerFactory.getLogger(MechanicController.class);

    @Autowired
    private MechanicRepository mechanicRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Mechanic> getMechanics(){
        logger.info("Send all Mechanics to Request");
        return mechanicRepository.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mechanic getMechanic(@PathVariable int id){
        logger.info("Send Mechanic with id "+ id + "to Request");
        Optional<Mechanic> _mechanic = mechanicRepository.findById(id);
        if (!_mechanic.isPresent()) throw
                new NotFoundException("" + id, "Mechanic", "id");
        else
            return _mechanic.get();

    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mechanic savedMechanic(@RequestBody Mechanic mechanic){
        Mechanic savedMechanic = mechanicRepository.save(mechanic);
        logger.info("Save Mechanic id " + savedMechanic.getId() + " to Database");
        return savedMechanic;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteMechanic(@PathVariable int id){
        logger.info("Delete Mechanic with id "+ id + "to Request");
        Optional<Mechanic> _mechanic = mechanicRepository.findById(id);
        if (!_mechanic.isPresent()) throw
                new NotFoundException("" + id, "Mechanic", "id");
        else{
            mechanicRepository.deleteById(id);
            return "Deleted";}
    }
}
