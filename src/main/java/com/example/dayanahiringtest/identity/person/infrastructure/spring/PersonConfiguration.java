package com.example.dayanahiringtest.identity.person.infrastructure.spring;

import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.infrastructure.persistence.jpa.SQLPersonDataAccessor;
import com.example.dayanahiringtest.identity.person.infrastructure.persistence.jpa.SQLPersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {
    @Bean
    public PersonRepository personRepository(
            SQLPersonDataAccessor dataAccessor,
            PersonDataMapper dataMapper
    ) {
        return new SQLPersonRepository(dataAccessor, dataMapper);
    }

    @Bean
    PersonDataMapper dataMapper() {
        return new PersonDataMapper();
    }
}
