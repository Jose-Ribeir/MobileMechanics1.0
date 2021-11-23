package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.ModelEngine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ModelEngineRepository extends CrudRepository<ModelEngine, Integer> {


    //Optional<ModelEngine> findmodelEngineEngineIdBymodelEngineEngineId(int id);
}