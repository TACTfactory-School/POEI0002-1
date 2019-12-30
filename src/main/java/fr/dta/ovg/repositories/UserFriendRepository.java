package fr.dta.ovg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.entities.UserFriend;

/** User Friend Repository extends JPA Repository. */
public interface UserFriendRepository extends JpaRepository<UserFriend, Long> {

    /** Exist by username function.
     * @param user : @see User.
     * @return true if the language already exist in the repository.*/
    @Query("SELECT COUNT(e) > 0" + " FROM User e" + " WHERE LOWER(e.username) = LOWER(:#{#s.username})"
            + " AND (:#{#s.id} = NULL OR e.id != :#{#s.id})")
    boolean existsByUsername(@Param("s") User user);

    /** Find all notifications by User id.
     * @param pageableFinal : @see Pageable.
     * @param userId : User id Notifications.
     * @return Notifications page object.*/
      @Query("SELECT f FROM UserFriend f "
                  + "INNER JOIN f.friendRequest r "
                  + "INNER JOIN f.friendAccept a "
                  + "WHERE a.id = :userId ") //  + "AND a.id = :userId"
      Page<UserFriend> findAllByUserId(Pageable pageableFinal, @Param("userId") long userId);

}
