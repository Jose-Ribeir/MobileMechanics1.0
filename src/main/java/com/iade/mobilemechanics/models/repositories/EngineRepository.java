package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Engine;
import com.iade.mobilemechanics.models.ModelEngine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EngineRepository extends CrudRepository<Engine, Integer> {

    String query = "select e.* from model_engine, engines e ,models where model_engine_model_id = model_id and model_engine_engine_id = engine_id";

    @Query(value = query + " and model_id= ?1", nativeQuery = true)
    Iterable<Engine> findByValue(int id);

}