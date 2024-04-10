package com.example.dayanahiringtest.identity;

import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.vo.NameVo;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;
import com.example.dayanahiringtest.identity.person.infrastructure.persistence.inmemory.InMemoryPersonRepository;
import com.example.dayanahiringtest.identity.verification.application.usecases.CheckPersonExistenceCommand;
import com.example.dayanahiringtest.identity.verification.application.usecases.CheckPersonExistenceCommandHandler;
import com.example.dayanahiringtest.identity.verification.domain.service.PersonVerificationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CheckPersonExistenceTests {
    @Test
    public void shouldCheckPersonExistence() {
        PersonVerificationService personVerificationService = new PersonVerificationService();

        var existingPerson1 = Person.create(
                new NiuVo("P059116609705Y"),
                new NameVo("John"),
                new NameVo("Doe"),
                LocalDate.now()
        );
        var existingPerson2 = Person.create(
                new NiuVo("P059116689705Y"),
                new NameVo("Johny"),
                new NameVo("Doemlh"),
                LocalDate.now()
        );
        var repository = new InMemoryPersonRepository();
        repository.save(existingPerson1);
        repository.save(existingPerson2);

        var useCase = new CheckPersonExistenceCommandHandler(repository, personVerificationService);
        var command = new CheckPersonExistenceCommand(
                existingPerson1.getNiu().value()
        );
        command.setName("Jonas");
        command.setSurname("Doe");
        command.setBirthDate("1998-05-05");

        var result = useCase.handle(command);

        Assertions.assertNotNull(result);

    }
}
