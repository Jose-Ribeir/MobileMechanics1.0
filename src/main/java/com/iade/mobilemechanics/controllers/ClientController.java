package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Brand;
import com.iade.mobilemechanics.models.Car;
import com.iade.mobilemechanics.models.Client;
import com.iade.mobilemechanics.models.Person;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.ClientRepository;
import com.iade.mobilemechanics.models.repositories.PersonRepository;
import com.iade.mobilemechanics.models.request.ClientRequeste;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/clients")
public class ClientController {
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientRepository clientRepository;
    private PersonRepository personRepository;

    public ClientController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Client> getClients(){
        logger.info("Send all Clients to Request");
        return clientRepository.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getClient(@PathVariable int id){
        logger.info("Send Client with id "+ id + "to Request");
        Optional<Client> _client = clientRepository.findById(id);
        if (!_client.isPresent()) throw
                new NotFoundException("" + id, "Client", "id");
        else
            return _client.get();
    }

    @GetMapping(path = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getClientId(@PathVariable int id){
        logger.info("Send Client with id "+ id + "to Request");
        Optional<Client> _client = clientRepository.findByClientPersonId(id);
        if (!_client.isPresent()) throw
                new NotFoundException("" + id, "Client", "id");
        else
            return _client.get().getId();
        //dsadsa
    }



    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client saveClientforeingkey(@RequestBody ClientRequeste client){

        Optional<Person> person = personRepository.findById(client.getClientPerson());
        Client client1 = new Client();
        client1.setClientNif(String.valueOf(client.getClientNif()));
        client1.setClientPerson(person.get());

        Client saveClient = clientRepository.save(client1);

        logger.info("Save Client id " + saveClient.getId() + " to Database");
        return saveClient;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteClient(@PathVariable int id){
        logger.info("Delete Client with id "+ id + "to Request");
        Optional<Client> _client = clientRepository.findById(id);
        if (!_client.isPresent()) throw
                new NotFoundException("" + id, "Client", "id");
        else{
            clientRepository.deleteById(id);
            return "Deleted";}
    }
}
