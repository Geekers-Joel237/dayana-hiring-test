package com.example.dayanahiringtest.core.infrastructure.persitence.inmemory;

import com.example.dayanahiringtest.core.domain.model.BaseEntity;
import com.example.dayanahiringtest.core.application.ports.BaseRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class InMemoryBaseRepository<T extends BaseEntity> implements BaseRepository<T> {
    protected final Map<String, T> entities = new HashMap<>();

    @Override
    public Optional<T> findById(String id) {
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public void save(T entity) {
        entities.put(entity.getId(), entity);
    }

    @Override
    public List<T> findAll() {
        return entities.values().stream().toList();
    }
}
