package fr.dta.ovg.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dta.ovg.security.entities.SecurityUser;

public interface SecurityUserRepository extends JpaRepository<SecurityUser, String> {

    public SecurityUser findByUsername(String username);

}
