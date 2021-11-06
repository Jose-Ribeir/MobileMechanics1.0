package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Model;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model, Integer> {
}