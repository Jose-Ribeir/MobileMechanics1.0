package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.TypeRepair;
import com.iade.mobilemechanics.models.TypeRepairRepair;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TypeRepairRepairRepository extends CrudRepository<TypeRepairRepair, Integer> {

    Optional<TypeRepairRepair> findByTypeRepairId(int id);


}