package com.example.dayanahiringtest.identity.person.application.usecases.create;

import an.awesome.pipelinr.Command;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.IdResponse;

public record CreatePersonCommand(String niu, String name, String surname,
                                  String birthDate) implements Command<IdResponse> {

}
