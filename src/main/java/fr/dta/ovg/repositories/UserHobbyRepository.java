package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.UserHobby;

/** User Hobby Repository extends JPA Repository. */
@Repository
public interface UserHobbyRepository extends JpaRepository<UserHobby, Long> {

}
