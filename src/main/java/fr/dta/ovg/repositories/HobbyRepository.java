/* Hobby Repository class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.contracts.HobbyContract;
import fr.dta.ovg.entities.Hobby;

/** Hobby Repository extends Jpa Repository. */
@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long> {


    /** Exist by hobby label Function.
     * @param hobby : Hobby entity.
     * @return true if the hobby already exist in the repository.*/
    @Query(HobbyContract.EXISTS_BY_LABEL)
      boolean existsByLabel(@Param("s") Hobby hobby);
}
