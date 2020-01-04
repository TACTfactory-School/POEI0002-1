/* User Repository class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved.*/
package fr.dta.ovg.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.contracts.UserContract;
import fr.dta.ovg.entities.User;

/** User Repository extends Jpa Repository. */
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    /** Exist by username function.
     * @param user : @see User.
     * @return true if the language already exist in the repository.*/
    @Query(UserContract.EXISTS_BY_USERNAME)
    boolean existsByUsername(@Param("s") User user); // TODO Delete this function - move to user

    /** Find All User Function.
     * @param search : string to process seach.
     * @param pageable : abstract interface for user pagination.
     * @return Page of users.*/
    @Query(value = UserContract.SEL_ALL_WHERE_NAME_LIKE,
            nativeQuery = true)
    Page<User> findAll(String search, Pageable pageable);

    /** Find by username Otionnal Function.
     * @param login : String.
     * @return an Optional.*/
    Optional<User> findByUsername(String login);
}
