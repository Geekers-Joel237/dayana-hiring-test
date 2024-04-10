package com.example.dayanahiringtest.identity.person.infrastructure.spring.http.controller;

import an.awesome.pipelinr.Pipeline;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.GetAllPersonsViewModel;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.IdResponse;
import com.example.dayanahiringtest.identity.person.infrastructure.spring.factories.GetAllPersonsFactory;
import com.example.dayanahiringtest.identity.person.infrastructure.spring.http.request.CreatePersonDto;
import com.example.dayanahiringtest.identity.person.infrastructure.spring.factories.CreatePersonFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final Pipeline pipeline;

    public PersonController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @GetMapping
    public ResponseEntity<GetAllPersonsViewModel> getAllPersons(
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) Integer offset
    ) {
        var command = GetAllPersonsFactory.build(limit,offset);
        var result = this.pipeline.send(command);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IdResponse> createPerson(@RequestBody CreatePersonDto dto) {
        var command = CreatePersonFactory.buildFromRequest(dto);
        var result = this.pipeline.send(command);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
