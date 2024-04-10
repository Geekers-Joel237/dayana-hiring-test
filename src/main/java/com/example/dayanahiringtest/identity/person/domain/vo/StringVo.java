package com.example.dayanahiringtest.identity.person.domain.vo;

import com.example.dayanahiringtest.core.domain.exceptions.NotNullException;

public class StringVo {
    private final String value;

    public StringVo(String value) {
        validate(value);
        this.value = value;
    }

    protected static void validate(String value) {
        if (value.isEmpty()) {
            throw new NotNullException("This character string cannot be empty!");
        }
    }

    public String value() {
        return this.value;
    }
}
