package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Person;
import com.iade.mobilemechanics.models.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/persons")
public class PersonController {
    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private PersonRepository personRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> getPerson(){
        logger.info("Send all Person to Request");
        return personRepository.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Person> getPerson(@PathVariable int id){
        logger.info("Send Person with id "+ id + "to Request");
        return personRepository.findById(id);
    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person savedPerson(@RequestBody Person mechanic){
        Person savedPerson = personRepository.save(mechanic);
        logger.info("Save Client id " + savedPerson.getId() + " to Database");
        return savedPerson;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deletePerson(@PathVariable int id){
        logger.info("Delete Person with id "+ id + "to Request");
        personRepository.deleteById(id);
        return "Deleted";
    }
}
