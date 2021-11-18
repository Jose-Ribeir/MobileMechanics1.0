package com.iade.mobilemechanics.controllers;

import com.iade.mobilemechanics.models.Model;
import com.iade.mobilemechanics.models.Person;
import com.iade.mobilemechanics.models.Price;
import com.iade.mobilemechanics.models.Repair;
import com.iade.mobilemechanics.models.exceptions.NotFoundException;
import com.iade.mobilemechanics.models.repositories.PersonRepository;
import com.iade.mobilemechanics.models.repositories.PriceRepository;
import com.iade.mobilemechanics.models.repositories.RepairRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/prices")
public class PriceController {

    @Autowired
    private PriceRepository priceRepository;

    @GetMapping(path = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Price> getPrice(@RequestParam(value = "modelId", defaultValue = "nome") String modelId,
                                    @RequestParam(value = "typeRepairId", defaultValue = "nome") String typeRepairId) {
        int _modelId = 0, _typeRepairId = 0;
        try {
            _modelId = Integer.parseInt(modelId);
        } catch (NumberFormatException e) {
        }
        try {
            _typeRepairId = Integer.parseInt(typeRepairId);
        } catch (NumberFormatException e) {
        }
        return priceRepository.findByPriceModelIdAndPriceTypeRepairId(_modelId, _typeRepairId);
    }

}

