package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dta.ovg.entities.Hobby;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {


    @Query("SELECT COUNT(h) > 0" + " FROM Hobby h" + " WHERE LOWER(h.label) = LOWER(:#{#s.label})"
            + " AND (:#{#s.id} = NULL OR h.id != :#{#s.id})")
      boolean existsByLabel(@Param("s") Hobby hobby);
}
