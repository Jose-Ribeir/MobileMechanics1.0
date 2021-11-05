package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Repair;
import com.iade.mobilemechanics.models.repositories.RepairRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/repairs")
public class RepairController {
    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private RepairRepository repairRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Repair> getRepair() {
        logger.info("Send all Repairs to Request");
        return repairRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Repair> getRepair(@PathVariable int id) {
        logger.info("Send Repair with id " + id + "to Request");
        return repairRepository.findById(id);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Repair savedRepair(@RequestBody Repair mechanic) {
        Repair savedPRepair = repairRepository.save(mechanic);
        logger.info("Save Repair id " + savedPRepair.getId() + " to Database");
        return savedPRepair;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteRepair(@PathVariable int id) {
        logger.info("Delete Repair with id " + id + "to Request");
        repairRepository.deleteById(id);
        return "Deleted";
    }
}
