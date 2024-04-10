package com.example.dayanahiringtest.identity.person.infrastructure.persistence.inmemory;

import com.example.dayanahiringtest.core.infrastructure.persitence.inmemory.InMemoryBaseRepository;
import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;


import java.util.Optional;

public class InMemoryPersonRepository extends InMemoryBaseRepository<Person> implements PersonRepository {
    @Override
    public Optional<Person> findByNiu(NiuVo niu) {
        return entities.values().stream()
                .filter(person -> person.getNiu().value().equals(niu.value()))
                .findFirst();
    }

}
