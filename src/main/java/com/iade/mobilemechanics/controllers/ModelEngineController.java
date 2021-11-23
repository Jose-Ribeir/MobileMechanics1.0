package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Car;
import com.iade.mobilemechanics.models.Engine;
import com.iade.mobilemechanics.models.ModelEngine;
import com.iade.mobilemechanics.models.exceptions.AlreadyExistsException;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.EngineRepository;
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
    @Autowired
    private EngineRepository engineRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ModelEngine> getModelEngine() {
        logger.info("Send all Brands to Request");
        return modelEngineRepository.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Engine> getModelEngine(@PathVariable int id) {
        return engineRepository.findByValue(id);
    }

    //@GetMapping(path = "/{id}/{id1}", produces = MediaType.APPLICATION_JSON_VALUE)
    //        public ModelEngine getModelEngine(@PathVariable int id, int id1) {
    //            logger.info("Send car with id " + id + "to Request");
    //            Optional<ModelEngine> _modelEngine =modelEngineRepository.findmodelEngineEngineIdBymodelEngineEngineId(id);
    //            if (!_modelEngine.isPresent()) throw
    //                    new NotFoundException("" + id, "Car", "id");
    //            else
    //                return _modelEngine.get();
    //       }



}
