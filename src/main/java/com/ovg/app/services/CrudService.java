package com.ovg.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ovg.app.entities.EntityBase;

public class CrudService<T extends EntityBase, R extends JpaRepository<T, Long>> {
    @Autowired
    private R repository;

    protected CrudService() {
        super();
    }

    protected final R getRepository() {
        return repository;
    }

    protected List<T> findAll() {
        return this.repository.findAll();
    }
}
