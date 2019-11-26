/* Entity base class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import fr.dta.ovg.entities.Event;

/** Event Repository extends Jpa Repository */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    /* EXAMPLES of futures User functions.
     *
     * import org.springframework.data.jpa.repository.Query;
     * import org.springframework.data.repository.query.Param;
     *
     * boolean existsByLabelIgnoreCase(String label);
     *
     * boolean existsByLabelIgnoreCaseAndIdNot(String label, Long id);
     *
     * @Query("SELECT p FROM PokemonSpecies p WHERE p.id = ?1")
     * PokemonSpecies findOne(Long id);
     *
     * @Query("SELECT p FROM PokemonSpecies p WHERE p.id = :myId")
     * PokemonSpecies findOne(@Param("myId") Long id);
     */

     // TODO Delete this function - move to user
     @Query("SELECT COUNT(e) > 0" + " FROM Event e" + " WHERE LOWER(e.label) = LOWER(:#{#s.label})"
            + " AND (:#{#s.id} = NULL OR e.id != :#{#s.id})")
      boolean existsByLabel(@Param("s") Event event);

}
