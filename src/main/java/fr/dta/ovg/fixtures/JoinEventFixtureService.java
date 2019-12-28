/* JoinEvent Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */

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

/** This class initialize DB join table with initials fixtures data. */
@Component
@Profile("!prod")
public class JoinEventFixtureService extends FixtureCheck<JoinEventRepository> {

    /** Link to Join CRUD Service. */
    private final JoinCrudService joinService;

    /** Link to Event CRUD Service. */
    private final EventCrudService eventService;

    /** Link to User CRUD Service. */
    private final UserCrudService userService;

    /** Event Faker Size. */
    private final int eventFakerSize;

    /** User Faker Size. */
    private final int userFakerSize;

    /** Local Constructor.
     * @param joinService : @see JoinCrudService.
     * @param eventService : @see EventCrudService.
     * @param userService : @see UserCrudService.
     * @param eventFakerSize : @see application-dev.properties.
     * @param userFakerSize : @see application-dev.properties.*/
    public JoinEventFixtureService(
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


    /** Fixtures are loaded only if no data.
     * @throws NotFoundException : JoinEvent entity not found.*/
    @Override
    protected void loadIfNoData() throws NotFoundException {
        this.loadReal();
    }

    /** Build manually some real JoinEvent fixture.
     * @throws NotFoundException : JoinEvent entity not found.*/
    private void loadReal() throws NotFoundException {

        final Random rand = new Random();

        for (int i = 0; i < eventFakerSize; i++) {
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

    /** JoinEvent Builder.
     * @param event : Event entity.
     * @param user : User entity.
     * @param role : EventRole Enum.
     * @param valid : true if user can participation to event.*/
    private void buildJoin(final Event event, final User user, final EventRole role, final boolean valid) {

        if (!event.getUsersJoin()
                  .stream()
                  .filter(e -> e.getUser().equals(user) || event.getCreator().equals(user))
                  .findFirst()
                  .isPresent()) {

            final JoinEvent join = new JoinEvent();

            join.setEvent(event);
            join.setUser(user);
            join.setRole(role);
            join.setValid(valid);

            joinService.create(join);
        }
    }
}
