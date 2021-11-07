package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Brand;
import com.iade.mobilemechanics.models.Engine;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.BrandRepository;
import com.iade.mobilemechanics.models.repositories.EngineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/engines")
public class EngineController {
    private final Logger logger = LoggerFactory.getLogger(EngineController.class);

    @Autowired
    private EngineRepository engineRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Engine> getEngines() {
        logger.info("Send all Engines to Request");
        return engineRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Engine getEngine(@PathVariable int id) {
        logger.info("Send Engine with id " + id + "to Request");
        Optional<Engine> _engine = engineRepository.findById(id);
        if (!_engine.isPresent()) throw
                new NotFoundException("" + id, "Engine", "id");
        else
            return _engine.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Engine savedEngine(@RequestBody Engine engine) {
        Engine savedEngine = engineRepository.save(engine);
        logger.info("Save Engine id " + savedEngine.getId() + " to Database");
        return savedEngine;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteEngine(@PathVariable int id) {
        logger.info("Delete Engine with id " + id + "to Request");
        Optional<Engine> _engine = engineRepository.findById(id);
        if (!_engine.isPresent()) throw
                new NotFoundException("" + id, "Engine", "id");
        else{
            engineRepository.deleteById(id);
            return "Deleted";}
    }
}
