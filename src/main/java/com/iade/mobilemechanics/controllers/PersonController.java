package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Car;
import com.iade.mobilemechanics.models.Person;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
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
    public Iterable<Person> getPersons(){
        logger.info("Send all Persons to Request");
        return personRepository.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(@PathVariable int id){
        logger.info("Send Person with id "+ id + "to Request");
        Optional<Person> _person = personRepository.findById(id);
        if (!_person.isPresent()) throw
                new NotFoundException("" + id, "Person", "id");
        else
            return _person.get();
    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person savedPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        logger.info("Save Client id " + savedPerson.getId() + " to Database");
        return savedPerson;
    }
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deletePerson(@PathVariable int id){
        logger.info("Delete Person with id "+ id + "to Request");
        Optional<Person> _person = personRepository.findById(id);
        if (!_person.isPresent()) throw
                new NotFoundException("" + id, "Person", "id");
        else{
            personRepository.deleteById(id);
            return "Deleted";}
    }
}
