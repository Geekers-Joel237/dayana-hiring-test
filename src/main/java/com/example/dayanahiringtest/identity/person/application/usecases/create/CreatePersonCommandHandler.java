package com.example.dayanahiringtest.identity.person.application.usecases.create;

import an.awesome.pipelinr.Command;
import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.IdResponse;
import com.example.dayanahiringtest.identity.person.domain.vo.NameVo;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;

import java.time.LocalDate;

public class CreatePersonCommandHandler implements Command.Handler<CreatePersonCommand, IdResponse> {
    private final PersonRepository personRepository;

    public CreatePersonCommandHandler(PersonRepository repository) {
        this.personRepository = repository;
    }

    @Override
    public IdResponse handle(CreatePersonCommand command) {
        NiuVo niu = new NiuVo(command.niu());
        NameVo name = new NameVo(command.name());
        NameVo surname = new NameVo(command.surname());
        LocalDate date = LocalDate.parse(command.birthDate());

        var person = Person.create(
                niu, name, surname, date
        );
        personRepository.save(person);

        return new IdResponse(person.getId());
    }
}
