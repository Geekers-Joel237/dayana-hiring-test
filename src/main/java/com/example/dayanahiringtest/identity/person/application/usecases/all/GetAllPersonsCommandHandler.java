package com.example.dayanahiringtest.identity.person.application.usecases.all;

import an.awesome.pipelinr.Command;
import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.PersonViewModel;

import java.util.List;

public class GetAllPersonsCommandHandler implements Command.Handler<GetAllPersonsCommand, List<PersonViewModel>> {
    private final PersonRepository personRepository;

    public GetAllPersonsCommandHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonViewModel> handle(GetAllPersonsCommand getAllPersonsCommand) {
        return personRepository.findAll().stream().map(this::toPersonViewModel).toList();
    }

    private PersonViewModel toPersonViewModel(Person p) {
        return new PersonViewModel(
                p.getId(),
                p.getNiu().value(),
                p.getName().value(),
                p.getSurname().value(),
                p.getBirthDate().toString()
        );
    }
}
