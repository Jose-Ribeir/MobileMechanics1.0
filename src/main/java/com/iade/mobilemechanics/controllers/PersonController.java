package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Brand;
import com.iade.mobilemechanics.models.Person;
import com.iade.mobilemechanics.models.exceptions.AlreadyExistsException;
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
    private final Logger logger = LoggerFactory.getLogger(PersonController.class);

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
    public Person savePerson(@RequestBody Person person){
       boolean a=false,b=false;

        Optional<Person> _person = personRepository.findPersonEmailByPersonEmail(person.getPersonEmail());
        Optional<Person> _person1 = personRepository.findPersonPersonPhoneNumberByPersonPhoneNumber(person.getPersonPhoneNumber());

        if (_person.isPresent()) {
           a=true;
        }
        if (_person1.isPresent()) {
            b=true;
               }
        if(a && b){
            throw new AlreadyExistsException(person.getPersonEmail(), "Email and Phone number", person.getPersonPhoneNumber());
        }

         if (a){
             throw new AlreadyExistsException(person.getPersonEmail(), "Email", "");
         }
         else if(b){
             throw new AlreadyExistsException(person.getPersonPhoneNumber(), "Phone Number", "");
         }


        Person savePerson = personRepository.save(person);
        logger.info("Save Client id " + savePerson.getId() + " to Database");
        return savePerson;
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
