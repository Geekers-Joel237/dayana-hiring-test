package com.example.dayanahiringtest.identity.person.domain.model;

import com.example.dayanahiringtest.identity.person.domain.vo.NameVo;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;
import java.time.LocalDate;
import java.util.UUID;


public class Person {

    private String id;
    private NiuVo niu;
    private NameVo name;
    private NameVo surname;
    private LocalDate birthDate;

    public Person() {
    }

    public Person(
            String id,
            NiuVo niu,
            NameVo name,
            NameVo surname,
            LocalDate birthDate
    ) {
        this.id = id;
        this.niu = niu;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public NiuVo getNiu() {
        return niu;
    }

    public NameVo getName() {
        return name;
    }

    public NameVo getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public static Person create(
            NiuVo niu,
            NameVo name,
            NameVo surname,
            LocalDate birthDate
    ) {

        return new Person(
                UUID.randomUUID().toString(),
                niu,
                name,
                surname,
                birthDate
        );
    }
}
