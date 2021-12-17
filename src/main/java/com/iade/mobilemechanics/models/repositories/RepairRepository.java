package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Repair;
import org.springframework.data.repository.CrudRepository;

public interface RepairRepository extends CrudRepository<Repair, Integer> {
    Iterable<Repair> findByRepairCarId(int id);
}
