package com.example.dayanahiringtest.identity.verification.application.usecases;

import an.awesome.pipelinr.Command;
import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.vo.NameVo;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;
import com.example.dayanahiringtest.identity.person.infrastructure.persistence.inmemory.InMemoryPersonRepository;
import com.example.dayanahiringtest.identity.verification.domain.exceptions.NotFoundPersonException;
import com.example.dayanahiringtest.identity.verification.domain.service.PersonVerificationService;
import com.example.dayanahiringtest.identity.verification.domain.viewmodel.PersonVerificationResult;
import com.example.dayanahiringtest.identity.verification.domain.vo.VerificationCriteria;

import java.time.LocalDate;

public class CheckPersonExistenceCommandHandler implements Command.Handler<CheckPersonExistenceCommand, PersonVerificationResult> {
    private final PersonRepository personRepository;
    private final PersonVerificationService personVerificationService;

    public CheckPersonExistenceCommandHandler(InMemoryPersonRepository personRepository,  PersonVerificationService personVerificationService) {
        this.personRepository = personRepository;
        this.personVerificationService = personVerificationService;
    }

    @Override
    public PersonVerificationResult handle(CheckPersonExistenceCommand command) {
        NiuVo niu = new NiuVo(command.getNiu());
        NameVo name = command.getName() != null ? new NameVo(command.getName()) : null;
        NameVo surname = command.getSurname() != null ? new NameVo(command.getSurname()): null;
        LocalDate date = command.getBirthDate() != null ? LocalDate.parse(command.getBirthDate()) : null;

        var existingPerson = this.getPersonOrThrowNotFoundException(niu);
        var verificationCriteria = VerificationCriteria.create(niu,name,surname,date);
        var scoreResult = this.personVerificationService.verify(existingPerson, verificationCriteria);

        return null;
    }

    private Person getPersonOrThrowNotFoundException(NiuVo niu) {
        var existingPerson = this.personRepository.findByNiu(niu);
        if (existingPerson.isEmpty()) {
            throw new NotFoundPersonException("No matches found for this NIU!");
        }
        return existingPerson.get();
    }
}
