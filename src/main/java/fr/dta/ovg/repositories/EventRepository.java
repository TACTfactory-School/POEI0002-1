/* Event Repository class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.repositories;

import org.springframework.data.domain.Pageable;

import java.time.ZonedDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.contracts.EventContract;
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
            value = EventContract.SEL_ALL_WHERE_TITLE_LIKE,
            nativeQuery = true)
    Page<Event> findAll(String search, Pageable pageable);

    /** Find All by past date Event Function.
     * @param date : date to process search.
     * @param pageable : abstract interface for event pagination.
     * @return Page of events.
     */
    @Query(
            value = EventContract.SEL_ALL_PAST_DATE,
            nativeQuery = true)
    Page<Event> findAllByPastDate(ZonedDateTime date, Pageable pageable);

    /** Find All by coming date Event Function.
     * @param date : date to process search.
     * @param pageable : abstract interface for event pagination.
     * @return Page of events.
     */
    @Query(
            value = EventContract.SEL_ALL_COMING_DATE,
            nativeQuery = true)
    Page<Event> findAllByComingDate(ZonedDateTime date, Pageable pageable);

    /** Find All by date Event Function.
     * @param date : date to process search.
     * @param pageable : abstract interface for event pagination.
     * @return Page of events.
     */
    @Query(
            value = EventContract.SEL_ALL_BY_DATE,
            nativeQuery = true)
    Page<Event> findAllByDate(ZonedDateTime date, Pageable pageable);

}
