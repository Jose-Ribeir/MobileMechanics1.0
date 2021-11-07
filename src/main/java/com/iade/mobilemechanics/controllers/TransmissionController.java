package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Review;
import com.iade.mobilemechanics.models.Transmission;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.ReviewRepository;
import com.iade.mobilemechanics.models.repositories.TransmissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/transmissions")
public class TransmissionController {
    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private TransmissionRepository transmissionRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Transmission> getTransmissions(){
        logger.info("Send all transmissions to Request");
        return transmissionRepository.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Transmission getReview(@PathVariable int id){
        logger.info("Send transmission with id "+ id + "to Request");
        Optional<Transmission> _transmission = transmissionRepository.findById(id);
        if (!_transmission.isPresent()) throw
                new NotFoundException("" + id, "transmission", "id");
        else
            return _transmission.get();
    }
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Transmission savedTransmission(@RequestBody Transmission transmission){
        Transmission savedTransmission = transmissionRepository.save(transmission);
        logger.info("Save transmission id " + savedTransmission.getId() + " to Database");
        return savedTransmission;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteReview(@PathVariable int id){
        logger.info("Delete review with id "+ id + "to Request");
        Optional<Transmission> _transmission = transmissionRepository.findById(id);
        if (!_transmission.isPresent()) throw
                new NotFoundException("" + id, "transmission", "id");
        else{
            transmissionRepository.deleteById(id);
            return "Deleted";}
    }
}
