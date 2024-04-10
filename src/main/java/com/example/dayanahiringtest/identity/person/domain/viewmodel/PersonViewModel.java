package com.example.dayanahiringtest.identity.person.domain.viewmodel;

import java.time.LocalDate;

public class PersonViewModel {
    private String id;
    private String niu;
    private String name;
    private String surname;

    private String birthDate;

    public PersonViewModel() {
    }

    public PersonViewModel(String id, String niu, String name, String surname, String birthDate) {
        this.id = id;
        this.niu = niu;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public String getNiu() {
        return niu;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
