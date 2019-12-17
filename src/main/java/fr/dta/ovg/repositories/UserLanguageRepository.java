package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.UserLanguage;

/** Language Level Repository extends Jpa Repository. */
@Repository
public interface UserLanguageRepository  extends JpaRepository<UserLanguage, Long> {

}
