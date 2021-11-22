package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.ModelEngine;
import com.iade.mobilemechanics.models.exceptions.AlreadyExistsException;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.ModelEngineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/modelengines")
public class ModelEngineController {
    private final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private ModelEngineRepository modelEngineRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ModelEngine> getModelEngine() {
        logger.info("Send all Brands to Request");
        return modelEngineRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelEngine getModelEngine(@PathVariable int id) {
        logger.info("Send Brand with id " + id + "to Request");
        Optional<ModelEngine> _modelEngine = modelEngineRepository.findById(id);
        if (!_modelEngine.isPresent()) throw
                new NotFoundException("" + id, "Brand", "id");
        else
            return _modelEngine.get();
    }



}
