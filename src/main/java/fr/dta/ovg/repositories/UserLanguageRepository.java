/* User Language Join Table Repository class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.UserLanguage;

/** User Language Join table Repository (include language level) extends JPA Repository. */
@Repository
public interface UserLanguageRepository  extends JpaRepository<UserLanguage, Long> {

}
