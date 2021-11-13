package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.TypeRepair;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TypeRepairRepository extends CrudRepository<TypeRepair, Integer> {
    Iterable<TypeRepair> findByTypeRepairNameContaining(String name);
    Iterable<TypeRepair> findByTypeRepairNameContains(String name);
    Optional<TypeRepair> findByTypeRepairName(String name);
}