package fr.dta.ovg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dta.ovg.contracts.UserContract;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.entities.UserFriend;

/** User Friend Repository extends JPA Repository. */
public interface UserFriendRepository extends JpaRepository<UserFriend, Long> {

    /** Exist by username function.
     * @param user : @see User.
     * @return true if the language already exist in the repository.*/
    @Query(UserContract.EXISTS_BY_LABEL)
    boolean existsByUsername(@Param("s") User user);

    /** Find all User Friends by ID.
     * @param pageableFinal : @see Pageable.
     * @param userId : User ID.
     * @return UserFriend page object.*/
      @Query(UserContract.SEL_ALL_BY_USER_ID) //  + "AND a.id = :userId"
      Page<UserFriend> findAllByUserId(Pageable pageableFinal, @Param("userId") long userId);

}
