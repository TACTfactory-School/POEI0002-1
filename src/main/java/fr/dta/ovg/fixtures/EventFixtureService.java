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

    /** Link to Event Create Service. */
    private final EventCreateService eventService;

    /** Link to User CRUD Service. */
    private final UserCrudService userService;

    /** Link to Join CRUD Service. */
    private final JoinCrudService joinService;

    /** Event Faker Size. */
    private int eventFakerSize;

    /** User Faker Size. */
    private int userFakerSize;

    /** Samy ID.*/
    private static final byte SAMY = 1;

    /** Colin ID.*/
    private static final byte COLIN = 1;

    /** Fabrice ID.*/
    private static final byte FAB = 1;

    /** Test ID.*/
    private static final byte TEST = 1;

    /** Define new Faker and set Local to french FR. */
    private final Faker fake = new Faker(new Locale("fr"));

    /** Local Constructor.
     * @param eventFakerSize : @see application-dev.properties.
     * @param userFakerSize : @see application-dev.properties.
     * @param eventService : @see EventCreateService.
     * @param userService : @see UserCrudService.
     * @param joinService : @see JoinCrudService.*/
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

    /** Create-Drop DB - Insert initial data, erasing old data every run (create-drop mode).
     * Fixtures are loaded only if no data.
     * @throws NotFoundException : Event entity not found.*/
    @Override
    public void loadIfNoData() throws NotFoundException {
        this.loadReal();
        this.loadFake();
    }

    /** Build manually some real Event fixture.
     * @throws NotFoundException : Event entity not found.*/
    private void loadReal() throws NotFoundException {

        ZonedDateTime start = ZonedDateTime.now();

        this.build("Supra Party One",   userService.getOne(SAMY),       "C'est super génial Viendez",
                    start,              "img1",                         25,
                    "5 rue du chat",    "35000",                        "Rennes",
                    this.eventTypeStore().get(1));

        this.build("Poke GO",           userService.getOne(COLIN),      "Chasse aux pokemons",
                    start,              "img1",                         20,
                    "5 chemin des eaux", "49000",                       "Angers",
                    this.eventTypeStore().get(2));

        this.build("GameBox",           userService.getOne(FAB),        "RetroGamin Event #7",
                    start,              "img1",                         15,
                    "5 bld Nerobi",     "69000",                        "Lyon",
                    this.eventTypeStore().get(3));

        this.build("Dotball",           userService.getOne(TEST),       "Jeux de sports & pinball",
                    start,              "img1",                         5,
                    "15 rue Paul Bert", "75000",                        "Paris",
                    this.eventTypeStore().get(4));
    }

    /** Event Builder function.
     * @param label : event label.
     * @param creator : event creator.
     * @param description : event description.
     * @param startAt : event start date.
     * @param img : event image.
     * @param nbPlaceMax : event max places.
     * @param address : event address.
     * @param postcode : event postcode.
     * @param city : event city.
     * @param type : event type.*/
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

    /** Build fake event fixtures function.*/
    private void loadFake() {
        IntStream.range(0, this.eventFakerSize).forEach(this::buildFake);
    }


    /** Faker builder Function.
     * @param i : faker size option.*/
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
                    this.eventTypeStore().get(rand.nextInt(13)));
        } catch (NotFoundException e) {
            e.getMessage();
        }
    }

    /** Event Type Storage Function.
     * @return List of Event type.*/
    private ArrayList<EventType> eventTypeStore() {

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

