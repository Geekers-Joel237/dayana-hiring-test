package com.example.dayanahiringtest.identity.person.infrastructure.spring.config;

import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.application.usecases.all.GetAllPersonsCommandHandler;
import com.example.dayanahiringtest.identity.person.application.usecases.create.CreatePersonCommandHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonUseCaseConfiguration {
    @Bean
    public CreatePersonCommandHandler createPersonUseCase(PersonRepository repository){
        return new CreatePersonCommandHandler(repository);
    }

    @Bean
    public GetAllPersonsCommandHandler getAllPersonsUseCase(PersonRepository repository){
        return new GetAllPersonsCommandHandler(repository);
    }
}
