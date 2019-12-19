/* Entity base class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.Event;

/** Event Repository extends Jpa Repository. */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    /** Find All Event Function.
     * @param search : string to process search.
     * @param pageable : abstract interface for event pagination.
     * @return Page of events.
     */
    @Query(
            value = "SELECT * FROM app_events e WHERE e.ev_title like %?1%",
            nativeQuery = true)
    Page<Event> findAll(String search, Pageable pageable);

}
