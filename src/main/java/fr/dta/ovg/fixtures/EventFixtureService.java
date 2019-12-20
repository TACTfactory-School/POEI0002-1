/* Event Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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
import fr.dta.ovg.entities.EventRole;
import fr.dta.ovg.entities.EventType;
import fr.dta.ovg.entities.JoinEvent;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.EventRepository;
import fr.dta.ovg.services.JoinCrudService;
import fr.dta.ovg.services.UserCrudService;
import fr.dta.ovg.services.event.EventCreateService;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class EventFixtureService extends FixtureCheck<EventRepository> {

    private final EventCreateService eventService;

    private final UserCrudService userService;

    private final JoinCrudService joinService;

    private int eventFakerSize;

    private int userFakerSize;


    private final Faker fake = new Faker(new Locale("fr"));

    /**
     * Local Constructor.
     *  Link to Event Create Service.
     *  Get Value of fakerSize @see application.properties. */
     public EventFixtureService(
            @Value("${app.event.fixtures.fakersize:100}") final int eventFakerSize,
            @Value("${app.user.fixtures.fakersize:100}") final int userFakerSize,
            @Autowired final EventCreateService eventService,
            @Autowired final UserCrudService userService,
            @Autowired final JoinCrudService joinService) {
        this.eventFakerSize = eventFakerSize;
        this.userFakerSize = userFakerSize;
        this.eventService = eventService;
        this.userService = userService;
        this.joinService = joinService;
    }

    /** Create-Drop DB - Insert initial data, erasing old data every run.
     * @throws NotFoundException */
    @Override
    public void loadIfNoData() throws NotFoundException {
        this.loadReal();
        this.loadFake();
    }

    private void loadReal() throws NotFoundException {

        ZonedDateTime start = ZonedDateTime.now();

        this.build("Supra Party One",   userService.getOne(1),          "C'est super génial Viendez",
                    start,              "img1",                         25,
                    "5 rue du chat",    "35000",                        "Rennes",
                    this.EventTypeStore().get(1));

        this.build("Poke GO",           userService.getOne(2),          "Chasse aux pokemons",
                    start,              "img1",                         25,
                    "5 chemin des eaux", "49000",                        "Angers",
                    this.EventTypeStore().get(2));

        this.build("GameBox",           userService.getOne(3),          "RetroGamin Event #7",
                    start,              "img1",                         25,
                    "5 bld Nerobi",     "69000",                        "Lyon",
                    this.EventTypeStore().get(3));

        this.build("Dotball",           userService.getOne(4),          "Jeux de sports & pinball",
                    start,              "img1",                         25,
                    "15 rue Paul Bert", "75000",                        "Paris",
                    this.EventTypeStore().get(4));
    }

    private void build(final String label, final User creator, final String description,
            final ZonedDateTime startAt, final String img, final int nbPlaceMax,
            final String address, final String postcode, final String city, final EventType type) {

        final Event event = new Event();
        final JoinEvent join = new JoinEvent();

        event.setLabel(label);
        event.setCreator(creator);
        event.setDescription(description);
        event.setStartAt(startAt);
        event.setImg(img);
        event.setNbPlaceMax(nbPlaceMax);
        event.setAddress(address);
        event.setPostcode(postcode);
        event.setCity(city);
        event.setType(type);

        eventService.create(event);

        // ADD Creator to each event
        join.setValid(true);
        join.setUser(creator);
        join.setRole(EventRole.CREATOR);
        join.setEvent(event);

        joinService.create(join);

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
                        .toInstant().atZone(ZoneId.systemDefault()),
                    this.fake.avatar().toString(),
                    rand.nextInt(100),
                    this.fake.address().streetAddress(),
                    this.fake.address().zipCode(),
                    this.fake.address().city(),
                    this.EventTypeStore().get(rand.nextInt(13)));
        } catch (NotFoundException e) {
            e.getMessage();
        }
    }

    /** Event Type Storage Function.
     * @return List of Event type.*/
    private ArrayList<EventType> EventTypeStore() {

        ArrayList<EventType> type = new ArrayList<EventType>();

        type.add(EventType.ARCADE);
        type.add(EventType.BIRTHDAY);
        type.add(EventType.COCKTAIL);
        type.add(EventType.CONFERENCE);
        type.add(EventType.ESPORT);
        type.add(EventType.FESTIVAL);
        type.add(EventType.LAN);
        type.add(EventType.OTHER);
        type.add(EventType.RESTAURANT);
        type.add(EventType.RETROGAMING);
        type.add(EventType.SPORT);
        type.add(EventType.THEMATICPARTY);
        type.add(EventType.TOURNAMENTS);
        type.add(EventType.VIDEOGAMES);

        return type;
    }
}

