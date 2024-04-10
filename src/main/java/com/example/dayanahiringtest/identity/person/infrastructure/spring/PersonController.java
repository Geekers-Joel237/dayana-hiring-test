package com.example.dayanahiringtest.identity.person.infrastructure.spring;

import an.awesome.pipelinr.Pipeline;
import com.example.dayanahiringtest.identity.person.domain.viewmodel.IdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final Pipeline pipeline;
    public PersonController(Pipeline pipeline){
        this.pipeline = pipeline;
    }

    @PostMapping
    public ResponseEntity<IdResponse> createPerson(@RequestBody CreatePersonDto dto) {
        var command = CreatePersonFactory.buildFromRequest(dto);
        var result = this.pipeline.send(command);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
