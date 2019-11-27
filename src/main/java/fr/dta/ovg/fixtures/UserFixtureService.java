/* ùser Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.services.user.UserCreateService;

@Component
@Profile("!prod")
public class UserFixtureService implements Fixture {

    private final UserCreateService service;

    private int fakerSize;

    private final Faker fake = new Faker(Locale.FRENCH);

    /**
     * Local Constructor
     * Link to User Repository by UserCreateService
     * Get Value of fakerSize @see application.properties */
    public UserFixtureService(
            @Value("${app.user.fixtures.fakersize:100}") final int fakerSize,
            @Autowired final UserCreateService service) {
        this.fakerSize = fakerSize;
        this.service = service;
    }

    /** Create-Drop DB - Insert initial data, erasing old data every run. */
    @Override
    public void load() {
        this.loadReal();
        this.loadFake();
    }

    private void loadReal() {
        this.build("Marty", "marty@hotmail.fr", "mar4567ty", LocalDate.of(1970, 01, 01));
        this.build("Xerox", "xerox4@me.com", "ezfhui43F", LocalDate.of(1982, 11, 06));
        this.build("Polo", "polo4life@4ever.org", "poloPOLO", LocalDate.of(1990, 07, 18));
    }

    private void build(final String username, final String email, final String password, final LocalDate birthdate) {

        final User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setBirthdate(birthdate);

        service.create(user);
    }

    private void loadFake() {
        IntStream.range(0, this.fakerSize).forEach(this::buildFake);
    }

    private void buildFake(int i) {

        UniqFakeStore username = new UniqFakeStore(() -> this.fake.name().username());
        UniqFakeStore email = new UniqFakeStore(() -> this.fake.internet().emailAddress());

        this.build(username.genUniqValue(),
                email.genUniqValue(),
                this.fake.internet().password(),
                this.fake.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

}
