package com.example.dayanahiringtest.core.domain.model;

public abstract class BaseEntity {
    protected String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
