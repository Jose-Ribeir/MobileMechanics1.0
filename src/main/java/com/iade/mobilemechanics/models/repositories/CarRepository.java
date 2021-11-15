package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Brand;
import com.iade.mobilemechanics.models.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Integer> {
   Iterable<Car>findByCarClientId(int id);
}



