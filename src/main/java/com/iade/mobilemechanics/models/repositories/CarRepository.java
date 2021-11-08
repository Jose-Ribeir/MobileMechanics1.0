package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
    Iterable<Car>findCarByCarClientId(int id);
}