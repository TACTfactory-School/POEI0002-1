/* Fixtures DB Service implement Class.
 * @author Colin Cerveaux @C-ambium
 * FixtureService implementation class of @see Fixtures Interface
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.exceptions.NotFoundException;

/** Fixtures Service implementation Class.*/
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

    /** Link to Notification Setting Fixture Service. */
    @Autowired
    private NotificationSettingFixtureService prefFixture;

    /** Link to Language Fixture Service. */
    @Autowired
    private LanguageFixtureService langFixture;

    /** Link to Language Fixture Service. */
    @Autowired
    private UserFriendFixtureService friendFixture;

    /** Call loading initials fixtures.
     * @see EventFixtureService.
     * @see UserFixtureService.
     * @see HobbyFixtureService.
     * @see NotificationFixtureService.
     * @see MessageFixtureService.
     * @see JoinEventFixtureService.
     * @see NotificationSettingFixtureService.
     * @see LanguageFixtureService.
     * @see UserFriendFixtureServic.e
     * @throws NotFoundException : entity not found. */
    @Transactional
    public void load() throws NotFoundException {
        this.prefFixture.load();
        this.userFixture.load();
        this.eventFixture.load();
        this.messageFixture.load();
        this.notificationFixture.load();
        this.hobbyFixture.load();
        this.joinFixture.load();
        this.langFixture.load();
        this.friendFixture.load();
    }
}
