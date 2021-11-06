package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Reviews;
import org.springframework.data.repository.CrudRepository;

public interface ReviewsRepository extends CrudRepository<Reviews, Integer> {
}