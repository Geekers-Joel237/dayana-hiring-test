package com.example.dayanahiringtest.identity.person.application.usecases.all;

import an.awesome.pipelinr.Command;
import com.example.dayanahiringtest.identity.person.application.ports.PersonRepository;
import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.GetAllPersonsViewModel;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.PersonViewModel;


public class GetAllPersonsCommandHandler implements Command.Handler<GetAllPersonsCommand, GetAllPersonsViewModel> {
    private final PersonRepository personRepository;

    public GetAllPersonsCommandHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public GetAllPersonsViewModel handle(GetAllPersonsCommand command) {
        var response = new GetAllPersonsViewModel();
        var persons = personRepository.findAll().stream().map(this::toPersonViewModel).toList();
        response.total = persons.size();
        response.persons = command.limit() != null ? persons.subList(command.offset(), command.limit()) : persons;
        return response;
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
