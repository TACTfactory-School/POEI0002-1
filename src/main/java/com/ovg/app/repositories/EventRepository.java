package com.ovg.app.repositories;

import com.ovg.app.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Colin Cerveaux @C-ambium
 *
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    boolean existsByLabelIgnoreCase(String label);

    boolean existsByLabelIgnoreCaseAndIdNot(String label, Long id);

//    @Query("SELECT p FROM PokemonSpecies p WHERE p.id = ?1")
//    PokemonSpecies findOne(Long id);
//    @Query("SELECT p FROM PokemonSpecies p WHERE p.id = :myId")
//    PokemonSpecies findOne(@Param("myId") Long id);

    @Query("SELECT COUNT(e) > 0"
            + " FROM Event e"
            + " WHERE LOWER(e.label) = LOWER(:#{#s.label})"
            + " AND (:#{#s.id} = NULL OR e.id != :#{#s.id})")
    boolean existsByLabel(@Param("s") Event event);
}
