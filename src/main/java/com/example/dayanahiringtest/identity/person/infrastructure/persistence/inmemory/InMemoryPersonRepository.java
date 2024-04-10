package com.example.dayanahiringtest.identity.person.infrastructure.persistence.inmemory;

import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryPersonRepository implements PersonRepository {
    private final Map<String, Person> persons = new HashMap<>();

    @Override
    public Optional<Person> findById(String id) {
        return Optional.ofNullable(persons.get(id));
    }

    @Override
    public void save(Person person) {
        persons.put(person.getId(), person);
    }

    @Override
    public Optional<Person> findByNiu(NiuVo niu) {
        return persons.values().stream()
                .filter(person -> person.getNiu().value().equals(niu.value()))
                .findFirst();
    }

    @Override
    public List<Person> findAll() {
        return persons.values().stream().toList();
    }
}
