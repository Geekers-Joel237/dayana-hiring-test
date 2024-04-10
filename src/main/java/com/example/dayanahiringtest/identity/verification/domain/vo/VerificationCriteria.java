package com.example.dayanahiringtest.identity.verification.domain.vo;

import com.example.dayanahiringtest.identity.person.domain.vo.NameVo;
import com.example.dayanahiringtest.identity.person.domain.vo.NiuVo;
import com.example.dayanahiringtest.identity.person.domain.vo.StringVo;

import java.time.LocalDate;

public class VerificationCriteria {
    private NiuVo niu;
    private NameVo name;
    private NameVo surname;
    private StringVo date;

    public VerificationCriteria(NiuVo niu) {
        this.niu = niu;
    }

    public static VerificationCriteria create(NiuVo niu, NameVo name, NameVo surname, LocalDate date) {
        var self = new VerificationCriteria(niu);
        self.name = name;
        self.surname = surname;
        self.date = date != null ? new StringVo(date.toString()) : null;
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

    public StringVo getDate() {
        return date;
    }
}
