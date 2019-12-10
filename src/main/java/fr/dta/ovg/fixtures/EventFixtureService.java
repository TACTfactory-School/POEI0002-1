/* Event Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.EventRepository;
import fr.dta.ovg.services.UserCrudService;
import fr.dta.ovg.services.event.EventCreateService;

/** This class initialize DB with initials fixtures data */
@Component
@Profile("!prod")
public class EventFixtureService extends FixtureCheck<EventRepository> {

    private final EventCreateService eventService;

    private final UserCrudService userService;

    private int eventFakerSize;

    private int userFakerSize;


    private final Faker fake = new Faker(Locale.FRENCH);

    /**
     * Local Constructor
     *  Link to Event Create Service
     *  Get Value of fakerSize @see application.properties */
     public EventFixtureService(
            @Value("${app.event.fixtures.fakersize:50}") final int eventFakerSize,
            @Value("${app.user.fixtures.fakersize:100}") final int userFakerSize,
            @Autowired final EventCreateService eventService,
            @Autowired final UserCrudService userService) {
        this.eventFakerSize = eventFakerSize;
        this.userFakerSize = userFakerSize;
        this.eventService = eventService;
        this.userService = userService;
    }

    /** Create-Drop DB - Insert initial data, erasing old data every run.
     * @throws NotFoundException */
    @Override
    public void loadIfNoData() throws NotFoundException {
        this.loadReal();
        this.loadFake();
    }

    private void loadReal() throws NotFoundException {

        LocalDateTime start = LocalDateTime.now();

        this.build("Supra Party One",   userService.getOne(1),          "C'est super génial Viendez",
                    start,              "img1",                         25,
                    "5 rue du chat",    "35000",                        "Rennes");

        this.build("Poke GO",           userService.getOne(2),          "Chasse aux pokemons",
                    start,              "img1",                         25,
                    "5 chemin des eaux", "49000",                        "Angers");

        this.build("GameBox",           userService.getOne(3),          "RetroGamin Event #7",
                    start,              "img1",                         25,
                    "5 bld Nerobi",     "69000",                        "Lyon");

        this.build("Dotball",           userService.getOne(4),          "Jeux de sports & pinball",
                    start,              "img1",                         25,
                    "15 rue Paul Bert", "75000",                        "Paris");
    }

    private void build(final String label, final User creator, final String description,
            final LocalDateTime startAt, final String img, final int nbPlaceMax,
            final String address, final String postcode, final String city) {

        final Event event = new Event();

        event.setLabel(label);
        event.setCreator(creator);
        event.setDescription(description);
        event.setStartAt(startAt);
        event.setImg(img);
        event.setNbPlaceMax(nbPlaceMax);
        event.setAddress(address);
        event.setPostcode(postcode);
        event.setCity(city);

        eventService.create(event);
    }

    private void loadFake() {
        IntStream.range(0, this.eventFakerSize).forEach(this::buildFake);
    }

    private void buildFake(final int i) {

        Random rand = new Random();

        try {
            this.build(
                    this.fake.esports().event(),
                    userService.getOne(rand.nextInt(userFakerSize)), // this.fake.name().fullName(),
                    this.fake.gameOfThrones().quote(),
                    this.fake.date().future(rand.nextInt(2000) + 1, TimeUnit.DAYS)
                        .toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    this.fake.avatar().toString(),
                    rand.nextInt(100),
                    this.fake.address().streetAddress(),
                    this.fake.address().zipCode(),
                    this.fake.address().city());
        } catch (NotFoundException e) {
            e.getMessage();
        }
    }
}

