/* Fixtures DB Service implement Class.
 * @author Colin Cerveaux @C-ambium
 * FixtureService implementation class of @see Fixtures Interface
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.exceptions.NotFoundException;

@Component
@Profile("!prod")
public class FixtureService implements Fixture {

    /** Link to Event Fixture Service. */
    @Autowired
    private EventFixtureService eventFixture;

    /** Link to User Fixture Service. */
    @Autowired
    private UserFixtureService userFixture;

    /** Link to Hobby Fixture Service. */
    @Autowired
    private HobbyFixtureService hobbyFixture;

    /** Link to Hobby Fixture Service. */
    @Autowired
    private NotificationFixtureService notificationFixture;

    /** Link to Hobby Fixture Service. */
    @Autowired
    private MessageFixtureService messageFixture;

    /** Link to Hobby Fixture Service. */
    @Autowired
    private JoinEventFixtureService  joinFixture;

//    @Autowired
//    private SecurityUserFixtureService securityUserFixture;

//    @Autowired
//    private SecurityRoleFixtureService securityRoleFixture;

    /** Call loading initials fixtures @see {@link EventFixtureService}.
     *  @throws NotFoundException */
    public void load() throws NotFoundException {
        this.hobbyFixture.load();
        this.messageFixture.load();
        this.notificationFixture.load();
        this.userFixture.load();
        this.eventFixture.load();
        this.joinFixture.load();

//        this.securityUserFixture.load();
//        this.securityRoleFixture.load();
    }
}
