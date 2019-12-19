package fr.dta.ovg.repositories;

import fr.dta.ovg.entities.JoinEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** Join Event Repository extends Jpa Repository. */
@Repository
public interface JoinEventRepository extends JpaRepository<JoinEvent, Long> {

    /** Find a JoinEvent by Event ID and User ID.
     * @param eventId : the ID of the event we're looking for.
     * @param userId : the ID of the user we're looking for.
     * @return a JoinEvent.
     */
    @Query(
            value = "SELECT * FROM app_join_event e WHERE e.event_id = ?1 AND e.user_id = ?2 LIMIT 1",
            nativeQuery = true)
    JoinEvent findAllByEventAndUser(long eventId, long userId);

}
