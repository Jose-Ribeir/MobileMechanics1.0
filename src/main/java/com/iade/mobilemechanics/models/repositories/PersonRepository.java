package com.iade.mobilemechanics.models.repositories;

import com.iade.mobilemechanics.models.Brand;
import com.iade.mobilemechanics.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Optional<Person> findByPersonEmail(String email);

    Optional<Person> findPersonEmailByPersonEmail(String personEmail);

    Optional<Person> findPersonPersonPhoneNumberByPersonPhoneNumber(String personEmail);

    Optional<Person> findPersonEmailByPersonEmailAndPersonPassword(String user, String pass);
}