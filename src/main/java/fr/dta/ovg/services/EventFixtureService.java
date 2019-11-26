/* Event Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.repositories.EventRepository;

/** This class initialize DB with initials fixtures data */
@Component
@Profile("!prod")
public class EventFixtureService implements Fixture {

    /** Link to Event Repository */
    @Autowired
    private EventRepository repository;

    /** Create-Drop DB - Insert initial data, erasing old data every run. */
    @Override
    public void load() {
        Event event1 = new Event();
        Event event2 = new Event();
        Event event3 = new Event();
        Event event4 = new Event();

        event1.setLabel("Supra Party One");
        event2.setLabel("Poke GO");
        event3.setLabel("GameBox");
        event4.setLabel("Dotball");

        event1.setAuthor("Bernard Saulon");
        event2.setAuthor("Jean Peuplier");
        event3.setAuthor("Henry Noge");
        event4.setAuthor("Simon Clark");

        event1.setDescription("C'est super génial Viendez");
        event2.setDescription("Chasse aux pokemons");
        event3.setDescription("RetroGamin Event #7");
        event4.setDescription("Jeux de sports & pinball");

        this.repository.save(event1);
        this.repository.save(event2);
        this.repository.save(event3);
        this.repository.save(event4);
    }
}

