package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dta.ovg.entities.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    @Query("SELECT COUNT(h) > 0" + " FROM Language h" + " WHERE LOWER(h.label) = LOWER(:#{#s.label})"
            + " AND (:#{#s.id} = NULL OR h.id != :#{#s.id})")
      boolean existsByLabel(@Param("s") Language language);
}
