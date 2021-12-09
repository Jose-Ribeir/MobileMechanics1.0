package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findByClientPersonId(int id);
}