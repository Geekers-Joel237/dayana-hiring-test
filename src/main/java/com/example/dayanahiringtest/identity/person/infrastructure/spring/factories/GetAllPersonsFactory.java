package com.example.dayanahiringtest.identity.person.infrastructure.spring.factories;

import com.example.dayanahiringtest.core.domain.exceptions.InvalidArgumentException;
import com.example.dayanahiringtest.identity.person.application.usecases.all.GetAllPersonsCommand;

public class GetAllPersonsFactory {
    public static GetAllPersonsCommand build(Integer limit, Integer offset) {
        validate(limit, offset);
        return new GetAllPersonsCommand(limit, offset);
    }

    private static void validate(Integer limit, Integer offset) {
        if (
                (limit == null && offset != null) ||
                        (limit != null && offset == null)
        ) {
            throw new InvalidArgumentException("Invalid Command !");
        }
    }
}
