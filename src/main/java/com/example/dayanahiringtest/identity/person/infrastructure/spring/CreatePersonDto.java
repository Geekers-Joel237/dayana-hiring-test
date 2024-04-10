package com.example.dayanahiringtest.identity.person.infrastructure.spring;

public class CreatePersonDto {
    private String niu;
    private String name;
    private String surname;
    private String birthDate;

    public CreatePersonDto() {

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

    public CreatePersonDto(String niu, String name, String surname, String date) {
        this.niu = niu;
        this.name = name;
        this.surname = surname;
        this.birthDate = date;
    }
}
