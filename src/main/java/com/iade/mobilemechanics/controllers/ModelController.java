package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Model;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.ModelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/models")
public class ModelController {
    private final Logger logger = LoggerFactory.getLogger(ModelController.class);
    @Autowired

    private ModelRepository modelRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Model> getModels(){
        logger.info("Send all Models to Request");
        return modelRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Model getModel(@PathVariable int id){
        logger.info("Send model with id "+ id + "to Request");
        Optional<Model> _model = modelRepository.findById(id);
        if (!_model.isPresent()) throw
                new NotFoundException("" + id, "model", "id");
        else
            return _model.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Model saveModel(@RequestBody Model model){
        Model savedModel = modelRepository.save(model);
        logger.info("Save model id " + savedModel.getId() + " to Database");
        return savedModel;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteModel(@PathVariable int id){
        logger.info("Delete model with id "+ id + "to Request");
        Optional<Model> _model = modelRepository.findById(id);
        if (!_model.isPresent()) throw
                new NotFoundException("" + id, "model", "id");
        else{
            modelRepository.deleteById(id);
            return "Deleted";}
    }
}
