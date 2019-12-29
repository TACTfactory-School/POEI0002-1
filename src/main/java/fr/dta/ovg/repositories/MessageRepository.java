/* Message Repository class.
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

import fr.dta.ovg.entities.Message;

/** Message Repository extends Jpa Repository. */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

      /** Find all messages by User id.
     * @param pageableFinal : @see Pageable.
     * @param userId : User id Messages.
     * @return Messages page object.*/
    @Query("SELECT m FROM Message m "
                + "INNER JOIN m.userReceiver u "
                + "WHERE u.id = :userId "
                + "ORDER BY m.createdAt DESC")
    Page<Message> findAllByUserId(Pageable pageableFinal, @Param("userId") long userId);

}
