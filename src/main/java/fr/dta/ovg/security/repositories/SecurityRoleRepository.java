package fr.dta.ovg.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dta.ovg.security.entities.SecurityRole;

public interface SecurityRoleRepository extends JpaRepository<SecurityRole, Integer>{

    public List<SecurityRole> findByUsername(String username);

}
