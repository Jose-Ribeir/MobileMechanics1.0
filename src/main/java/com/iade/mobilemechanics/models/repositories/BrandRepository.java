package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Optional<Brand> findByBrandName(String name);
}