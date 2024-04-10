package com.example.dayanahiringtest.identity.person.application.usecases.all;

import an.awesome.pipelinr.Command;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.PersonViewModel;

import java.util.List;

public class GetAllPersonsCommand implements Command<List<PersonViewModel>> {
    public GetAllPersonsCommand() {
    }
}
