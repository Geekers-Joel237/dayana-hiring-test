package com.example.dayanahiringtest.identity.person.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SQLPersonDataAccessor extends JpaRepository<SqlPerson, String> {
    Optional<SqlPerson> findByNiu(String niu);
}
