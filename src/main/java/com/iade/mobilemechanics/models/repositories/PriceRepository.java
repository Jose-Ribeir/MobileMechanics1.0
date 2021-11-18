package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Price;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PriceRepository extends CrudRepository<Price, Integer> {
    Optional<Price> findByPriceModelIdAndPriceTypeRepairId(Integer priceModelId, Integer priceTypeRepairId);



}