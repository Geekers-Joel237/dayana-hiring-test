package com.example.dayanahiringtest.identity.person.infrastructure.persistence.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "persons")
public class SqlPerson {
    @Id
    private String id;
    @Column
    private String niu;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private LocalDate birthDate;

    public SqlPerson() {
    }

    public SqlPerson(String id, String niu, String name, String surname, LocalDate birthDate) {
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

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
