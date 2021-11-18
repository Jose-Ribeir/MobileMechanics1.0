package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Mechanic;
import org.springframework.data.repository.CrudRepository;

public interface MechanicRepository extends CrudRepository<Mechanic, Integer> {
    Iterable<Mechanic> findByMechanicAvailability(boolean t);
}