package com.example.dayanahiringtest.identity.person.infrastructure.spring;

import com.example.dayanahiringtest.identity.person.application.usecases.create.CreatePersonCommand;

public class CreatePersonFactory {
    public static CreatePersonCommand buildFromRequest(CreatePersonDto dto) {
        return new CreatePersonCommand(dto.getNiu(), dto.getName(), dto.getSurname(), dto.getBirthDate());
    }
}
