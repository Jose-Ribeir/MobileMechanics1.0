package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Model;
import com.iade.mobilemechanics.models.Repair;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
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
    private final Logger logger = LoggerFactory.getLogger(RepairController.class);

    @Autowired
    private RepairRepository repairRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Repair> getRepairs() {
        logger.info("Send all Repairs to Request");
        return repairRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Repair getRepair(@PathVariable int id) {
        logger.info("Send Repair with id " + id + "to Request");
        Optional<Repair> _repair = repairRepository.findById(id);
        if (!_repair.isPresent()) throw
                new NotFoundException("" + id, "Repair", "id");
        else
            return _repair.get();

    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Repair saveRepair(@RequestBody Repair repair) {
        Repair saveRepair = repairRepository.save(repair);
        logger.info("Save Repair id " + saveRepair.getId() + " to Database");
        return saveRepair;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteRepair(@PathVariable int id) {
        logger.info("Delete Repair with id " + id + "to Request");
        Optional<Repair> _repair = repairRepository.findById(id);
        if (!_repair.isPresent()) throw
                new NotFoundException("" + id, "Repair", "id");
        else{
            repairRepository.deleteById(id);
            return "Deleted";}
    }

    @GetMapping(path = "/car/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Repair> getRepairByCarId(@PathVariable int id){
        return repairRepository.findByRepairCarId(id);
    }
}
