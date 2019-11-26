package com.ovg.app.aexamples.fixtures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ovg.app.aexamples.fixtures.entities.Mug;

public interface MugRepository extends JpaRepository<Mug, Long> {
}
