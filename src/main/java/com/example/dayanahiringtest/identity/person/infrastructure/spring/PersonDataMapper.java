package com.example.dayanahiringtest.identity.person.infrastructure.spring;

import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.vo.NameVo;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;
import com.example.dayanahiringtest.identity.person.infrastructure.persistence.jpa.SqlPerson;

public class PersonDataMapper {
    public Person toDomain(SqlPerson person) {
        return new Person(
                person.getId(),
                new NiuVo(person.getNiu()),
                new NameVo(person.getName()),
                new NameVo(person.getSurname()),
                person.getBirthDate()
        );
    }

    public SqlPerson toPersistence(Person person) {
        return new SqlPerson(
                person.getId(),
                person.getNiu().value(),
                person.getName().value(),
                person.getSurname().value(),
                person.getBirthDate()
        );
    }
}
