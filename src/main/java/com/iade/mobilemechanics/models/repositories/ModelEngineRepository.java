package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.ModelEngine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ModelEngineRepository extends CrudRepository<ModelEngine, Integer> {

}