package com.example.dayanahiringtest.identity.person;

import com.example.dayanahiringtest.identity.person.application.usecases.create.CreatePersonCommand;
import com.example.dayanahiringtest.identity.person.application.usecases.create.CreatePersonCommandHandler;
import com.example.dayanahiringtest.identity.person.domain.exceptions.AlreadyExistNiuException;
import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.vo.NameVo;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;
import com.example.dayanahiringtest.identity.person.infrastructure.persistence.inmemory.InMemoryPersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CreatePersonTest {
    @Test
    public void shouldRunTest() {
        Assertions.assertEquals(1, 1);
    }

    @Test
    public void shouldCreatePerson() {
        var repository = new InMemoryPersonRepository();
        var useCase = new CreatePersonCommandHandler(repository);
        var command = new CreatePersonCommand(
                "P059116609705Y",
                "John",
                "Doe",
                "1998-05-05"
        );

        var result = useCase.handle(command);

        var expectedPerson = repository.findById(result.getId()).get();

        Assertions.assertEquals(result.getId(), expectedPerson.getId());
        Assertions.assertEquals(command.name(), expectedPerson.getName().value());
        Assertions.assertEquals(command.surname(), expectedPerson.getSurname().value());
        Assertions.assertEquals(command.niu(), expectedPerson.getNiu().value());
        Assertions.assertEquals(command.birthDate(), expectedPerson.getBirthDate().toString());
    }

    @Test
    public void shouldNotCreatePersonWhenNiuAlreadyExistThenThrowException() {
        var existingPerson = Person.create(
                new NiuVo("P059116609705Y"),
                new NameVo("John"),
                new NameVo("Doe"),
                LocalDate.now()
        );
        var personRepository = new InMemoryPersonRepository();
        personRepository.save(existingPerson);

        var command = new CreatePersonCommand(
                existingPerson.getNiu().value(),
                "John",
                "Doe",
                "1998-05-05"
        );
        var commandHandler = new CreatePersonCommandHandler(personRepository);

        Assertions.assertThrows(AlreadyExistNiuException.class, () -> commandHandler.handle(command));

    }
}
