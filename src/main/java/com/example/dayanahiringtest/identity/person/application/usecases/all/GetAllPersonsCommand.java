package com.example.dayanahiringtest.identity.person.application.usecases.all;

import an.awesome.pipelinr.Command;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.GetAllPersonsViewModel;


public record GetAllPersonsCommand(Integer limit, Integer offset) implements Command<GetAllPersonsViewModel> {
}
