package com.example.dayanahiringtest.identity.verification.application.usecases;

import an.awesome.pipelinr.Command;
import com.example.dayanahiringtest.identity.verification.domain.viewmodel.PersonVerificationResult;

public class CheckPersonExistenceCommand implements Command<PersonVerificationResult> {
    private String niu;
    private String name;
    private String surname;
    private String birthDate;

    public CheckPersonExistenceCommand(String niu) {
        this.niu = niu;
    }

    public String getNiu() {
        return niu;
    }

    public void setNiu(String niu) {
        this.niu = niu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
