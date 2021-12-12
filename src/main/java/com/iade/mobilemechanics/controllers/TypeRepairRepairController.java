package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.TypeRepair;
import com.iade.mobilemechanics.models.TypeRepairRepair;
import com.iade.mobilemechanics.models.exceptions.AlreadyExistsException;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.TypeRepairRepairRepository;
import com.iade.mobilemechanics.models.repositories.TypeRepairRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/typeRepairRepair")
public class TypeRepairRepairController {
    private final Logger logger = LoggerFactory.getLogger(TypeRepairController.class);

    @Autowired
    private TypeRepairRepairRepository typeRepairRepairRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TypeRepairRepair> getTypeRepairsRepairs(){
        logger.info("Send all typeRepairs to Request");
        return typeRepairRepairRepository.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TypeRepairRepair getTypeRepairRepair(@PathVariable int id){
        logger.info("Send TypeRepair with id "+ id + "to Request");
        Optional<TypeRepairRepair> _typeRepair = typeRepairRepairRepository.findById(id);
        if (!_typeRepair.isPresent()) throw
                new NotFoundException("" + id, "typeRepair", "id");
        else
            return _typeRepair.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public TypeRepairRepair saveTypeRepairRepair(@RequestBody TypeRepairRepair typeRepairRepair){
        Optional<TypeRepairRepair> _typeRepairRepair = typeRepairRepairRepository.findByTypeRepairId(typeRepairRepair.getTypeRepairRepairId());
        TypeRepairRepair saveTypeRepairRepair = typeRepairRepairRepository.save(typeRepairRepair);
        logger.info("Save typeRepair id " + saveTypeRepairRepair.getId() + " to Database");
        return saveTypeRepairRepair;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTypeRepairRepair(@PathVariable int id){
        logger.info("Delete typeRepair with id "+ id + "to Request");
        Optional<TypeRepairRepair> _typeRepairRepair = typeRepairRepairRepository.findById(id);
        if (!_typeRepairRepair.isPresent()) throw
                new NotFoundException("" + id, "typeRepair", "id");
        else{
            typeRepairRepairRepository.deleteById(id);
            return "Deleted";}
    }
}
