package com.example.dayanahiringtest.identity.person.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SQLPersonDataAccessor extends JpaRepository<SqlPerson, String> {
}
