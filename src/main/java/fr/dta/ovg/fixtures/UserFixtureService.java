/* User Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
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

import fr.dta.ovg.contracts.FixturesContract;
import fr.dta.ovg.entities.NotificationSetting;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.entities.UserGender;
import fr.dta.ovg.entities.UserStatus;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.UserRepository;
import fr.dta.ovg.services.notification.NotificationSettingCrudService;
import fr.dta.ovg.services.user.UserCreateService;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class UserFixtureService extends FixtureCheck<UserRepository> {

    /** Password encoder. */
    private final PasswordEncoder encoder;

    /** Link to User Create Service. */
    private final UserCreateService service;

    /** Link to User Create Service. */
    private final NotificationSettingCrudService prefService;

    /** Faker Size. */
    private int fakerSize;

    /** Define local constant rate for real fixtures build. */
    private static final float RATE = 4.7f;

    /** Define new Faker and set Local to french FR. */
    private final Faker fake = new Faker(new Locale("fr"));

    /** Check Uniq name with UniFakeStore Function. */
    private UniqFakeStore username = new UniqFakeStore(() -> this.fake.gameOfThrones().character());
    /** Check Uniq name with UniFakeStore Function. */
    private UniqFakeStore email = new UniqFakeStore(() -> this.fake.internet().safeEmailAddress());

    /** Local Constructor.
     * @param fakerSize : @see application-dev.properties.
     * @param encoder : @see PasswordEncoder.
     * @param service : @see UserCreateService.
     * @param prefService : @see NotificationSettingCrudService.*/
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

    /** Create-Drop DB - Insert initial data, erasing old data every run (create-drop mode).
     * Fixtures are loaded only if no data.
     * @throws NotFoundException : User entity not found.*/
    @Override
    public void loadIfNoData() throws NotFoundException {
        this.loadReal();
        this.loadFake();
    }

    /** Build some real user fixture.
     * @throws NotFoundException : Entity requested not found.*/
    private void loadReal() throws NotFoundException {
        this.build("Pamwamba",  "samy@hotmail.fr",      "samysamy",      FixturesContract.SAMY_BD,      "Samy",
                    "Nantes",   "Dev Fullstack",        RATE,            LocalDateTime.now(),
                    prefService.getOne(FixturesContract.SAMY),           FixturesContract.SAMY,
                    UserStatus.MARRIED,                 UserGender.MALE,
                    true,       false,                  false,           false,                         false);
        this.build("C-ambium",  "joe@me.com",           "colin",         FixturesContract.COLIN_BD,     "Colin",
                    "Rennes",   "Dev Fullstack",        RATE,            LocalDateTime.now(),
                    prefService.getOne(FixturesContract.COLIN),          FixturesContract.COLIN,
                    UserStatus.DIVORCED,                UserGender.MALE,
                    false,      false,                  false,           false,                         false);
        this.build("ListerKred", "fab@4ever.org",      "fabricefabrice", FixturesContract.FAB_BD,       "Fabrice",
                    "Angers",    "Dev Fullstack",       RATE,            LocalDateTime.now(),
                    prefService.getOne(FixturesContract.FAB),            FixturesContract.FAB,
                    UserStatus.SINGLE,                  UserGender.MALE,
                    false,       true,                  true,            false,                         false);
        this.build("test",      "test@test.org",        "test",          FixturesContract.TEST_BD,      "TestName",
                   "testCity",  "testjob",              RATE,            LocalDateTime.now(),
                   prefService.getOne(FixturesContract.TEST),            FixturesContract.TEST,
                   UserStatus.UNSPECIFIED,              UserGender.UNSPECIFIED,
                   true,        false,                  true,            false,                         true);
    }

    /** User Builder.
     * @param username : username.
     * @param email : user email.
     * @param password : user password.
     * @param birthdate : user birthdate.
     * @param firstname : user firstname.
     * @param city : user city.
     * @param job : user job.
     * @param rate : user rate.
     * @param lastLogin : user last login date.
     * @param pref : user preferences.
     * @param avatar : user avatar.
     * @param maritalStatus : user marital status.
     * @param gender : user gender.
     * @param birthdateHidden : hide birthdate option.
     * @param mailHidden : hide mail option.
     * @param jobHidden : hide job option.
     * @param genderHidden : hide gender option.
     * @param statusHidden : hide marital status option.*/
    private void build(
            final String username,      final String email,     final String password,
            final LocalDate birthdate,  final String firstname, final String city,
            final String job,           final float rate,       final LocalDateTime lastLogin,
            final NotificationSetting pref,     final byte avatar,
            final UserStatus maritalStatus,     final UserGender gender,
            final boolean birthdateHidden,      final boolean mailHidden,
            final boolean jobHidden,            final boolean genderHidden,
            final boolean statusHidden) {

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
        user.setAvatar(avatar);
        user.setMaritalStatus(maritalStatus);
        user.setGender(gender);
        user.setBirthdateHidden(birthdateHidden);
        user.setMailHidden(mailHidden);
        user.setJobHidden(jobHidden);
        user.setGenderHidden(genderHidden);
        user.setStatusHidden(statusHidden);

        service.create(user);
    }

    /** Build fake user fixtures function.*/
    private void loadFake() {
        IntStream.range(0, this.fakerSize).forEach(this::buildFake);
    }

    /** User Faker Builder.
     * @param i : TODO DELETE.*/
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
                    rand.nextFloat() + rand.nextInt(FixturesContract.NB_STARS),
                    this.fake.date()
                        .past(rand.nextInt(FixturesContract.DATE_SCALE) + 1, TimeUnit.DAYS)
                        .toInstant().atZone(zoneId)
                        .toLocalDateTime(),
                    prefService.getOne(FixturesContract.TEST),
                    (byte) rand.nextInt(FixturesContract.NB_DEFAULT_AVATAR),
                    userStatusStore().get(rand.nextInt(FixturesContract.US_STATUS_STORE_SIZE)),
                    userGenderStore().get(rand.nextInt(FixturesContract.US_GENDER_STORE_SIZE)),
                    rand.nextBoolean(),
                    rand.nextBoolean(),
                    rand.nextBoolean(),
                    rand.nextBoolean(),
                    rand.nextBoolean());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    /** User Status Storage Function.
     * @return List of User Status.*/
    private ArrayList<UserStatus> userStatusStore() {

        ArrayList<UserStatus> status = new ArrayList<UserStatus>();

        status.add(UserStatus.DIVORCED);
        status.add(UserStatus.MARRIED);
        status.add(UserStatus.SINGLE);
        status.add(UserStatus.WIDOWED);
        status.add(UserStatus.UNSPECIFIED);

        return status;
    }

    /** User Gender Storage Function.
     * @return List of User gender.*/
    private ArrayList<UserGender> userGenderStore() {

        ArrayList<UserGender> gender = new ArrayList<UserGender>();

        gender.add(UserGender.FEMALE);
        gender.add(UserGender.MALE);
        gender.add(UserGender.NONBINARY);
        gender.add(UserGender.UNSPECIFIED);

        return gender;
    }
}
