package com.example.dayanahiringtest.core.application.ports;


import com.example.dayanahiringtest.core.domain.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T extends BaseEntity> {
    Optional<T> findById(String id);
    void save(T person);
    List<T> findAll();
}
