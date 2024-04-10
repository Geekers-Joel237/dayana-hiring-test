package com.example.dayanahiringtest.identity.person.application.ports;

import com.example.dayanahiringtest.core.application.ports.BaseRepository;
import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;

import java.util.Optional;

public interface PersonRepository extends BaseRepository<Person> {
    Optional<Person> findByNiu(NiuVo niu);

}
