package com.example.dayanahiringtest.identity.verification.domain.service;

import com.example.dayanahiringtest.identity.person.domain.model.Person;
import com.example.dayanahiringtest.identity.person.domain.vo.StringVo;
import com.example.dayanahiringtest.identity.verification.domain.viewmodel.PersonVerificationResult;
import com.example.dayanahiringtest.identity.verification.domain.vo.VerificationCriteria;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class PersonVerificationService {

    public static final double DEFAULT_SCORE_VALUE = 0.0d;

    public PersonVerificationResult verify(Person existingPerson, VerificationCriteria verificationCriteria) {
        var scoreResult = new PersonVerificationResult();
        scoreResult.nameScore = this.buildScoreFrom(verificationCriteria.getName(), existingPerson.getName().value());
        scoreResult.surnameScore = this.buildScoreFrom(verificationCriteria.getSurname(), existingPerson.getSurname().value());
        //scoreResult.birthDateScore = this.buildScoreFrom(new verificationCriteria.getDate(), existingPerson.getBirthDate().toString());
        return scoreResult;
    }

    private double buildScoreFrom(StringVo valueFromCriteria, String valueFromExistingPerson) {
        if (valueFromCriteria == null) {
            return DEFAULT_SCORE_VALUE;
        }
        return StringUtils.getJaroWinklerDistance(valueFromCriteria.value(), valueFromExistingPerson);
    }


}
