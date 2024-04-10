package com.example.dayanahiringtest.identity.person.application.ports;

import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;

import java.util.Optional;

public interface PersonRepository {
    Optional<Person> findById(String id);

    void save(Person person);

    Optional<Person> findByNiu(NiuVo niu);
}
