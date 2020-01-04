/* Language Repository class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.contracts.LanguageContract;
import fr.dta.ovg.entities.Language;

/** Language Repository extends Jpa Repository. */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    /** Exist by language label Function.
     * @param language : @see Language.
     * @return true if the language already exist in the repository.*/
    @Query(LanguageContract.EXISTS_BY_LABEL)
      boolean existsByLabel(@Param("s") Language language);
}
