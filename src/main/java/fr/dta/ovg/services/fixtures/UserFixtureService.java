package fr.dta.ovg.services.fixtures;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.repositories.UserRepository;

@Component
@Profile("!prod")
public class UserFixtureService implements Fixture {

    /** Link to User Repository */
    @Autowired
    private UserRepository repository;

    /** Create-Drop DB - Insert initial data, erasing old data every run. */
    @Override
    public void load() {
        User user01 = new User();
        User user02 = new User();
        User user03 = new User();

        user01.setUsername("user01");
        user02.setUsername("user02");
        user03.setUsername("user03");

        user01.setEmail("user01@gmail.com");
        user02.setEmail("user02@gmail.com");
        user03.setEmail("user03@gmail.com");

        user01.setPassword("10resu");
        user02.setPassword("20resu");
        user03.setPassword("30resu");

        user01.setBirthdate(LocalDate.of(1970, 01, 01));
        user02.setBirthdate(LocalDate.of(1982, 11, 06));
        user03.setBirthdate(LocalDate.of(1990, 07, 18));

        this.repository.save(user01);
        this.repository.save(user02);
        this.repository.save(user03);
    }

}
