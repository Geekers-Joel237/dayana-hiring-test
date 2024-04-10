package com.example.dayanahiringtest.identity.verification.domain.service;

import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.verification.domain.viewmodel.PersonVerificationResult;
import com.example.dayanahiringtest.identity.verification.domain.vo.VerificationCriteria;
import org.springframework.stereotype.Service;

@Service
public class PersonVerificationService {
    public PersonVerificationResult verify(Person existingPerson, VerificationCriteria verificationCriteria) {
        var scoreResult = new PersonVerificationResult();
        scoreResult.nameScore = this.buildScoreFrom(verificationCriteria.getName().value(), existingPerson.getName().value());
        scoreResult.surnameScore = this.buildScoreFrom(verificationCriteria.getSurname().value(), existingPerson.getSurname().value());
        scoreResult.birthDateScore = this.buildScoreFrom(verificationCriteria.getDate().toString(), existingPerson.getBirthDate().toString());
        return scoreResult;
    }

    private double buildScoreFrom(String value, String value1) {
    }


}
