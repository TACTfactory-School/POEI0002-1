/* Join Event Repository class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.repositories;

import fr.dta.ovg.contracts.JoinEventContract;
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
            value = JoinEventContract.FIND_BY_USER_EVENT_ID,
            nativeQuery = true)
    JoinEvent findAllByEventAndUser(long eventId, long userId);

}
