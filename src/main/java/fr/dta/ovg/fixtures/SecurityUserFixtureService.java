package fr.dta.ovg.fixtures;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.security.entities.SecurityUser;
import fr.dta.ovg.security.repositories.SecurityUserRepository;

@Component
@Profile("!prod")
public class SecurityUserFixtureService extends FixtureCheck<SecurityUserRepository>{

    private final SecurityUserRepository repository;

    public SecurityUserFixtureService(@Autowired final SecurityUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void loadIfNoData() {

        List<SecurityUser> users = new ArrayList<>();

        users.add(new SecurityUser() {{setUsername("user1"); setPassword("user1"); setEnabled(true);}});
        users.add(new SecurityUser() {{setUsername("user2"); setPassword("user2"); setEnabled(true);}});

        repository.saveAll(users);

        }

}
