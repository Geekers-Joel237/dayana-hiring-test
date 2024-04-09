package com.example.dayanahiringtest.identity.person.infrastructure.persistence.inmemory;

import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.domain.model.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryPersonRepository implements PersonRepository {
   private final Map<String,Person> persons = new HashMap<>();
    @Override
    public Optional<Person> findById(String id) {
        return Optional.ofNullable(persons.get(id));
    }

    @Override
    public void save(Person person) {
        persons.put(person.getId(), person);
    }
}
