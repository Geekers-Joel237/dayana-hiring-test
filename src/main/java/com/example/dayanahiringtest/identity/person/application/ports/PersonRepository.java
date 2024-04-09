package com.example.dayanahiringtest.identity.person.application.ports;

import com.example.dayanahiringtest.identity.person.domain.model.Person;

import java.util.Optional;

public interface PersonRepository {
    Optional<Person> findById(String id);

    void save(Person person);
}
