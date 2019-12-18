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

      @Query("SELECT n FROM Notification n "
                + "INNER JOIN n.user u "
                + "WHERE u.id = :userId "
                + "ORDER BY n.createdAt DESC")
    Page<Message> findAllByUserId(Pageable pageableFinal, @Param("userId") final long userId);

}
