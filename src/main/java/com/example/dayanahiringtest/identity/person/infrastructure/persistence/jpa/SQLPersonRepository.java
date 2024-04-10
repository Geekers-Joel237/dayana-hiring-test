package com.example.dayanahiringtest.identity.person.infrastructure.persistence.jpa;

import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;
import com.example.dayanahiringtest.identity.person.infrastructure.spring.PersonDataMapper;

import java.util.List;
import java.util.Optional;

public class SQLPersonRepository implements PersonRepository {
    private final SQLPersonDataAccessor dataAccessor;
    private final PersonDataMapper dataMapper;

    public SQLPersonRepository(SQLPersonDataAccessor dataAccessor, PersonDataMapper dataMapper) {
        this.dataAccessor = dataAccessor;
        this.dataMapper = dataMapper;
    }

    @Override
    public Optional<Person> findById(String id) {
        var sqlQuery = dataAccessor.findById(id);
        return sqlQuery.map(dataMapper::toDomain);
    }


    @Override
    public void save(Person person) {
        dataAccessor.save(dataMapper.toPersistence(person));
    }

    @Override
    public Optional<Person> findByNiu(NiuVo niu) {
        var sqlQuery = dataAccessor.findByNiu(niu.value());
        return sqlQuery.map(dataMapper::toDomain);
    }

    @Override
    public List<Person> findAll() {
        return dataAccessor.findAll().stream().map(dataMapper::toDomain).toList();
    }
}
