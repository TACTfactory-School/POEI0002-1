package fr.dta.ovg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.User;

/** User Repository extends Jpa Repository. */
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {


//    /* EXAMPLES of futures User functions.
//     *
//     * import org.springframework.data.jpa.repository.Query;
//     * import org.springframework.data.repository.query.Param;
//     *
//     * boolean existsByLabelIgnoreCase(String label);
//     *
//     * boolean existsByLabelIgnoreCaseAndIdNot(String label, Long id);
//     *
//     * @Query("SELECT p FROM PokemonSpecies p WHERE p.id = ?1")
//     * PokemonSpecies findOne(Long id);
//     *
//     * @Query("SELECT p FROM PokemonSpecies p WHERE p.id = :myId")
//     * PokemonSpecies findOne(@Param("myId") Long id);
//     */

     // TODO Delete this function - move to user
    @Query("SELECT COUNT(e) > 0" + " FROM User e" + " WHERE LOWER(e.username) = LOWER(:#{#s.username})"
            + " AND (:#{#s.id} = NULL OR e.id != :#{#s.id})")
    boolean existsByUsername(@Param("s") User user);

    @Query(
            value = "SELECT * FROM app_users u WHERE u.us_username like %?1%",
            nativeQuery = true)
    Page<User> findAll(String search, Pageable pageable);

    User findByUsername(String login);
}
