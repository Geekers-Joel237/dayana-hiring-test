package com.example.dayanahiringtest.identity.person.infrastructure.spring;

import com.example.dayanahiringtest.identity.person.domain.exceptions.AlreadyExistNiuException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(
            AlreadyExistNiuException.class
    )
    ResponseEntity<String> handleAlreadyExistNiuException(AlreadyExistNiuException e) {
        return ResponseEntity.ok(e.getMessage());
    }
}
