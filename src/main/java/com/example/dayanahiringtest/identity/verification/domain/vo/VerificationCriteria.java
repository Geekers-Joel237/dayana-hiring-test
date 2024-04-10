package com.example.dayanahiringtest.identity.verification.domain.vo;

import com.example.dayanahiringtest.identity.person.domain.vo.NameVo;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;

import java.time.LocalDate;

public class VerificationCriteria {
    private NiuVo niu;
    private NameVo name;
    private NameVo surname;
    private LocalDate date;

    public VerificationCriteria(NiuVo niu) {
        this.niu = niu;
    }

    public static VerificationCriteria create(NiuVo niu, NameVo name, NameVo surname, LocalDate date) {
        var self = new VerificationCriteria(niu);
        self.name = name;
        self.surname = surname;
        self.date = date;
        return self;
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

    public LocalDate getDate() {
        return date;
    }
}
