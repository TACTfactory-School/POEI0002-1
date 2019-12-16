/* ùser Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.repositories.UserRepository;
import fr.dta.ovg.services.user.UserCreateService;

@Component
@Profile("!prod")
public class UserFixtureService extends FixtureCheck<UserRepository> {

    private final PasswordEncoder encoder;

    private final UserCreateService service;

    private int fakerSize;

    private final Faker fake = new Faker(Locale.FRENCH);

    private UniqFakeStore username = new UniqFakeStore(() -> this.fake.name().username());
    private UniqFakeStore email = new UniqFakeStore(() -> this.fake.internet().emailAddress());

    /**
     * Local Constructor.
     * Link to User Repository by UserCreateService.
     * Get Value of fakerSize @see application.properties. */
    public UserFixtureService(
            @Value("${app.user.fixtures.fakersize:100}") final int fakerSize,
            @Autowired() final PasswordEncoder encoder,
            @Autowired final UserCreateService service) {
        this.encoder = encoder;
        this.fakerSize = fakerSize;
        this.service = service;
    }

    /** Create-Drop DB - Insert initial data, erasing old data every run. */
    @Override
    public void loadIfNoData() {
        this.loadReal();
        this.loadFake();
    }

    private void loadReal() {
        this.build("Pamwamba",   "samy@hotmail.fr",      "samysamy",             LocalDate.of(1998, 9, 25),
                    "Samy",     "Nantes",               "Dev Fullstack", 15.5f, LocalDateTime.now());
        this.build("C-ambium",  "joe@me.com",           "colincolin",           LocalDate.of(1990, 06, 05),
                    "Colin",    "Rennes",               "Dev Fullstack", 14.2f, LocalDateTime.now());
        this.build("ListerKred", "fab@4ever.org",       "fabricefabrice",       LocalDate.of(1997, 04, 8),
                    "Fabrice",   "Angers",              "Dev Fullstack", 17.8f, LocalDateTime.now());
    }

    private void build(final String username, final String email,
            final String password, final LocalDate birthdate,
            final String firstname, final String city,
            final String job, final float rate, final LocalDateTime lastLogin) {

        final User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(this.encoder.encode(password));
        user.setBirthdate(birthdate);
        user.setFirstname(firstname);
        user.setCity(city);
        user.setJob(job);
        user.setRate(rate);
        user.setLastLogin(lastLogin);

        service.create(user);
    }

    private void loadFake() {
        IntStream.range(0, this.fakerSize).forEach(this::buildFake);
    }

    private void buildFake(final int i) {

        Random rand = new Random();
        ZoneId zoneId = ZoneId.of("Europe/Paris");        //Zone information

        this.build(username.genUniqValue(),
                email.genUniqValue(),
                this.fake.internet().password(),
                this.fake.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                this.fake.name().firstName(),
                this.fake.address().city(),
                this.fake.job().title(),
                rand.nextFloat(),
                this.fake.date()
                    .past(rand.nextInt(2000) + 1, TimeUnit.DAYS)
                    .toInstant().atZone(zoneId)
                    .toLocalDateTime());
    }

}
