package fr.dta.ovg.fixtures;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.security.entities.SecurityRole;
import fr.dta.ovg.security.repositories.SecurityRoleRepository;

@Component
@Profile("!prod")
public class SecurityRoleFixtureService implements Fixture {

    private final SecurityRoleRepository repository;

    public SecurityRoleFixtureService ( @Autowired final SecurityRoleRepository repository) {
        this.repository = repository;
    }


    @Override
    public void load() {

        List<SecurityRole> roles = new ArrayList<>();

        roles.add(new SecurityRole() { { setUsername("admin"); setRole("ADMIN");} } );
        roles.add(new SecurityRole() { { setUsername("user1"); setRole("USER");} } );

        repository.saveAll(roles);

        }

}
