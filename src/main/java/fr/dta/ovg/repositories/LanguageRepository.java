package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.Language;

/** Language Repository extends Jpa Repository. */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    /** Exist by language label Function.
     * @param language : @see Language.
     * @return true if the language already exist in the repository.*/
    @Query("SELECT COUNT(h) > 0" + " FROM Language h" + " WHERE LOWER(h.label) = LOWER(:#{#s.label})"
            + " AND (:#{#s.id} = NULL OR h.id != :#{#s.id})")
      boolean existsByLabel(@Param("s") Language language);
}
