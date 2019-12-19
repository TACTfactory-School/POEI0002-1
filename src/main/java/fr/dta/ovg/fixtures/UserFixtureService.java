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

import fr.dta.ovg.entities.NotificationSetting;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.UserRepository;
import fr.dta.ovg.services.notification.NotificationSettingCrudService;
import fr.dta.ovg.services.user.UserCreateService;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class UserFixtureService extends FixtureCheck<UserRepository> {

    private final PasswordEncoder encoder;

    private final UserCreateService service;

    private final NotificationSettingCrudService prefService;
    private int fakerSize;

    private final Faker fake = new Faker(new Locale("fr"));

    private UniqFakeStore username = new UniqFakeStore(() -> this.fake.gameOfThrones().character());
    private UniqFakeStore email = new UniqFakeStore(() -> this.fake.internet().safeEmailAddress());

    /**
     * Local Constructor.
     * Link to User Repository by UserCreateService.
     * Get Value of fakerSize @see application.properties. */
    public UserFixtureService(
            @Value("${app.user.fixtures.fakersize:100}") final int fakerSize,
            @Autowired() final PasswordEncoder encoder,
            @Autowired final UserCreateService service,
            @Autowired final NotificationSettingCrudService prefService) {
        this.encoder = encoder;
        this.fakerSize = fakerSize;
        this.service = service;
        this.prefService = prefService;
    }

    /** Create-Drop DB - Insert initial data, erasing old data every run.
     * @throws NotFoundException */
    @Override
    public void loadIfNoData() throws NotFoundException {
        this.loadReal();
        this.loadFake();
    }

    private void loadReal() throws NotFoundException {
        this.build("Pamwamba",  "samy@hotmail.fr",      "samysamy",             LocalDate.of(1998, 9, 25),
                    "Samy",     "Nantes",               "Dev Fullstack", 4.5f, LocalDateTime.now(),
                    prefService.getOne(1));
        this.build("C-ambium",  "joe@me.com",           "colin",                LocalDate.of(1990, 06, 05),
                    "Colin",    "Rennes",               "Dev Fullstack", 3.2f, LocalDateTime.now(),
                    prefService.getOne(2));
        this.build("ListerKred", "fab@4ever.org",        "fabricefabrice",       LocalDate.of(1997, 04, 8),
                    "Fabrice",  "Angers",               "Dev Fullstack", 5f, LocalDateTime.now(),
                    prefService.getOne(3));
        this.build("test",      "test@test.org",        "test",                 LocalDate.of(1999, 04, 8),
                   "test",      "test",                 "test",          0.5f,  LocalDateTime.now(),
                   prefService.getOne(4));
    }

    private void build(final String username, final String email,
            final String password, final LocalDate birthdate,
            final String firstname, final String city,
            final String job, final float rate, final LocalDateTime lastLogin,
            final NotificationSetting pref) {

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
        user.setPreferences(pref);

        service.create(user);
    }

    private void loadFake() {
        IntStream.range(0, this.fakerSize).forEach(this::buildFake);
    }

    private void buildFake(final int i) {

        Random rand = new Random();
        ZoneId zoneId = ZoneId.of("Europe/Paris");        //Zone information

        try {
            this.build(username.genUniqValue(),
                    email.genUniqValue(),
                    this.fake.internet().password(),
                    this.fake.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    this.fake.name().firstName(),
                    this.fake.address().city(),
                    this.fake.job().title(),
                    rand.nextFloat() + rand.nextInt(5),
                    this.fake.date()
                        .past(rand.nextInt(2000) + 1, TimeUnit.DAYS)
                        .toInstant().atZone(zoneId)
                        .toLocalDateTime(),
                    prefService.getOne(4));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
