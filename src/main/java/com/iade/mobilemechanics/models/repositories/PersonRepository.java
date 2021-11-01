package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}