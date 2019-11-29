/* Event Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import java.util.Locale;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.services.event.EventCreateService;

/** This class initialize DB with initials fixtures data */
@Component
@Profile("!prod")
public class EventFixtureService implements Fixture {

    private final EventCreateService service;

    private int fakerSize;

    private final Faker fake = new Faker(Locale.FRENCH);

    /**
     * Local Constructor
     *  Link to Event Create Service
     *  Get Value of fakerSize @see application.properties */
     public EventFixtureService(
            @Value("${app.event.fixtures.fakersize:50}") final int fakerSize,
            @Autowired final EventCreateService service) {
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
        this.build("Supra Party One",   "Bernard Saulon",       "C'est super génial Viendez");
        this.build("Poke GO",           "Jean Peuplier",        "Chasse aux pokemons");
        this.build("GameBox",           "Simon Clark",          "RetroGamin Event #7");
        this.build("Dotball",           "polo4life@4ever.org",  "Jeux de sports & pinball");

    }

    private void build(final String label, final String author, final String description) {

        final Event event = new Event();

        event.setLabel(label);
        event.setAuthor(author);
        event.setDescription(description);

        service.create(event);
    }

    private void loadFake() {
        IntStream.range(0, this.fakerSize).forEach(this::buildFake);
    }

    private void buildFake(int i) {

        this.build(this.fake.esports().event(),
                this.fake.name().fullName(),
                this.fake.gameOfThrones().quote());
    }

}

