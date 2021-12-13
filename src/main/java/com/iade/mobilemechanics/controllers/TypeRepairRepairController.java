package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.TypeRepairRepair;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.TypeRepairRepairRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/typeRepairRepair")
public class TypeRepairRepairController {
    private final Logger logger = LoggerFactory.getLogger(TypeRepairRepairController.class);

    @Autowired
    private TypeRepairRepairRepository repository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TypeRepairRepair> getTypeRepairsRepairs(){
        logger.info("Send all typeRepairs to Request");
        return repository.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TypeRepairRepair getTypeRepairRepair(@PathVariable int id){
        logger.info("Send TypeRepair with id "+ id + "to Request");
        Optional<TypeRepairRepair> _typeRepair = repository.findById(id);
        if (!_typeRepair.isPresent()) throw
                new NotFoundException("" + id, "typeRepair", "id");
        else
            return _typeRepair.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public TypeRepairRepair saveTypeRepairRepair(@RequestBody TypeRepairRepair typeRepairRepair){
        TypeRepairRepair saveTypeRepairRepair = repository.save(typeRepairRepair);
        logger.info("Save typeRepairRepair " + saveTypeRepairRepair.getId() + " to Database");
        return saveTypeRepairRepair;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTypeRepairRepair(@PathVariable int id){
        logger.info("Delete typeRepair with id "+ id + "to Request");
        Optional<TypeRepairRepair> _typeRepairRepair = repository.findById(id);
        if (!_typeRepairRepair.isPresent()) throw
                new NotFoundException("" + id, "typeRepair", "id");
        else{
            repository.deleteById(id);
            return "Deleted";}



    }
}
