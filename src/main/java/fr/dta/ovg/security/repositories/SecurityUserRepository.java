package fr.dta.ovg.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.security.entities.SecurityUser;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, String> {

    public SecurityUser findByUsername(String username);

}
