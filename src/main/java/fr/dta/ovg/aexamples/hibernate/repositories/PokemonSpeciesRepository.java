package com.ovg.app.aexamples.hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ovg.app.aexamples.hibernate.entities.PokemonSpecies;

public interface PokemonSpeciesRepository extends JpaRepository<PokemonSpecies, Long> {

    boolean existsByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCaseAndIdNot(String name, Long id);

//    @Query("SELECT p FROM PokemonSpecies p WHERE p.id = ?1")
//    PokemonSpecies findOne(Long id);
//    @Query("SELECT p FROM PokemonSpecies p WHERE p.id = :myId")
//    PokemonSpecies findOne(@Param("myId") Long id);

    @Query("SELECT COUNT(p) > 0"
            + " FROM PokemonSpecies p"
            + " WHERE LOWER(p.name) = LOWER(:#{#s.name})"
            + " AND (:#{#s.id} = NULL OR p.id != :#{#s.id})")
    boolean existsByName(@Param("s") PokemonSpecies species);
}
