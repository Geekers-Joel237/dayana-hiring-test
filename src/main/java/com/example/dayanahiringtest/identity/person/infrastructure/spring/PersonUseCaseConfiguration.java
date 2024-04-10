package com.example.dayanahiringtest.identity.person.infrastructure.spring;

import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.application.usecases.create.CreatePersonCommandHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonUseCaseConfiguration {
    @Bean
    public CreatePersonCommandHandler createPersonUseCase(PersonRepository repository){
        return new CreatePersonCommandHandler(repository);
    }
}
