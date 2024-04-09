package com.example.dayanahiringtest.identity.person;

import com.example.dayanahiringtest.identity.person.application.usecases.create.CreatePersonCommand;
import com.example.dayanahiringtest.identity.person.application.usecases.create.CreatePersonCommandHandler;
import com.example.dayanahiringtest.identity.person.infrastructure.persistence.inmemory.InMemoryPersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreatePersonTest {
    @Test
    public void shouldRunTest(){
        Assertions.assertEquals(1, 1);
    }
    @Test
    public void shouldCreatePerson() {
        var repository = new InMemoryPersonRepository();
        var useCase = new CreatePersonCommandHandler(repository);
        var command = new CreatePersonCommand(
                "P059116609705Y",
                "Ivan",
                "Joel",
                "1998-05-05"
        );

        var result = useCase.handle(command);

        var expectedPerson = repository.findById(result.getId()).get();

        Assertions.assertEquals(result.getId(),expectedPerson.getId());
        Assertions.assertEquals(command.name(),expectedPerson.getName().value());
        Assertions.assertEquals(command.surname(),expectedPerson.getSurname().value());
        Assertions.assertEquals(command.niu(),expectedPerson.getNiu().value());
        Assertions.assertEquals(command.birthDate(),expectedPerson.getBirthDate().toString());
    }
}
