package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Transmission;
import com.iade.mobilemechanics.models.TypeRepair;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.TransmissionRepository;
import com.iade.mobilemechanics.models.repositories.TypeRepairRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/typeRepair")
public class TypeRepairController {
    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private TypeRepairRepository typeRepairRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TypeRepair> getTypeRepairs(){
        logger.info("Send all typeRepairs to Request");
        return typeRepairRepository.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TypeRepair getTypeRepair(@PathVariable int id){
        logger.info("Send TypeRepair with id "+ id + "to Request");
        Optional<TypeRepair> _typeRepair = typeRepairRepository.findById(id);
        if (!_typeRepair.isPresent()) throw
                new NotFoundException("" + id, "typeRepair", "id");
        else
            return _typeRepair.get();
    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public TypeRepair savedTypeRepair(@RequestBody TypeRepair typeRepair){
        TypeRepair savedTypeRepair = typeRepairRepository.save(typeRepair);
        logger.info("Save typeRepair id " + savedTypeRepair.getId() + " to Database");
        return savedTypeRepair;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTypeRepair(@PathVariable int id){
        logger.info("Delete typeRepair with id "+ id + "to Request");
        Optional<TypeRepair> _typeRepair = typeRepairRepository.findById(id);
        if (!_typeRepair.isPresent()) throw
                new NotFoundException("" + id, "typeRepair", "id");
        else{
            typeRepairRepository.deleteById(id);
            return "Deleted";}
    }

}
