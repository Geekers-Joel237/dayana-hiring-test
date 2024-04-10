package com.example.dayanahiringtest.identity.person.domain.vo;

import com.example.dayanahiringtest.core.domain.exceptions.InvalidArgumentException;

/**
 * NIU valid
 * 14 characters, start with P or M
 * P059116609705Y
 * M072017804390K
 */
public class NiuVo extends StringVo {
    public NiuVo(String value) {
        super(value);
        validate(value);
    }

    protected static void validate(String value) {
        if (value.length() != 14) {
            throw new InvalidArgumentException("Your NIU must contain 14 characters!");
        }

        if (!((value.startsWith("P") || value.startsWith("M")))) {
            throw new InvalidArgumentException("Your NIU must start with M or P");
        }
    }
}
