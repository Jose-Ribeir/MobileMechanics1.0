package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Client;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.ClientRepository;
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
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client savedClient(@RequestBody Client client){
        Client savedClient = clientRepository.save(client);
        logger.info("Save Client id " + savedClient.getId() + " to Database");
        return savedClient;
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
