/* Notifications Repository class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved
 */

package fr.dta.ovg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.Notification;

/** Notification Repository extends Jpa Repository. */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    /** Find all notifications by User id.
   * @param pageableFinal : @see Pageable.
   * @param userId : User id Notifications.
   * @return Notifications page object.*/
    @Query("SELECT n FROM Notification n "
                + "INNER JOIN n.user u "
                + "WHERE u.id = :userId "
                + "ORDER BY n.createdAt DESC")
    Page<Notification> findAllByUserId(Pageable pageableFinal, @Param("userId") long userId);

}
