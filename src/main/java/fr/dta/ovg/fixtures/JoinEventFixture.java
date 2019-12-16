package fr.dta.ovg.fixtures;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.entities.EventRole;
import fr.dta.ovg.entities.JoinEvent;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.JoinEventRepository;
import fr.dta.ovg.services.EventCrudService;
import fr.dta.ovg.services.JoinCrudService;
import fr.dta.ovg.services.UserCrudService;

@Component
@Profile("!prod")
public class JoinEventFixture extends FixtureCheck<JoinEventRepository> {

    private final JoinCrudService joinService;

    private final EventCrudService eventService;

    private final UserCrudService userService;

    private int eventFakerSize;

    private int userFakerSize;

    public JoinEventFixture(
            @Autowired final JoinCrudService joinService,
            @Autowired final EventCrudService eventService,
            @Autowired final UserCrudService userService,
            @Value("${app.event.fixtures.fakersize:100}") final int eventFakerSize,
            @Value("${app.user.fixtures.fakersize:100}") final int userFakerSize) {

        this.joinService = joinService;
        this.eventService = eventService;
        this.userService = userService;
        this.eventFakerSize = eventFakerSize;
        this.userFakerSize = userFakerSize;
    }

    @Override
    protected void loadIfNoData() throws NotFoundException {
        this.loadReal();
    }

    private void loadReal() throws NotFoundException {

        Random rand = new Random();

        for (int i = 0; i < eventFakerSize ; i++) {
            // ADD some user pending or enrolled
            this.buildJoin(
                    eventService.getOne(rand.nextInt(eventFakerSize)),
                    userService.getOne(rand.nextInt(userFakerSize)),
                    EventRole.GUEST,
                    rand.nextBoolean());
            // ADD some organizers
            this.buildJoin(
                    eventService.getOne(rand.nextInt(eventFakerSize)),
                    userService.getOne(rand.nextInt(userFakerSize)),
                    EventRole.ORGANIZER,
                    true);
        }
    }

    private void buildJoin(final Event event, final User user, final EventRole role, final boolean valid) {

        JoinEvent join = new JoinEvent();

        join.setEvent(event);
        join.setUser(user);
        join.setRole(role);
        join.setValid(valid);

        joinService.create(join);
    }
}
