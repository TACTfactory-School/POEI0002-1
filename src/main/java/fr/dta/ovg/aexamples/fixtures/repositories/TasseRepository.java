package com.ovg.app.aexamples.fixtures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ovg.app.aexamples.fixtures.entities.Tasse;

public interface TasseRepository extends JpaRepository<Tasse, Long> {
}
