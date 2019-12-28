/* Notification Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.contracts.FixturesContract;
import fr.dta.ovg.entities.Notification;
import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.NotificationRepository;
import fr.dta.ovg.services.UserCrudService;
import fr.dta.ovg.services.notification.NotificationCrudService;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class NotificationFixtureService extends FixtureCheck<NotificationRepository> {

    /** Link to Notification CRUD Service. */
    private final NotificationCrudService notificationService;

    /** Link to User CRUD Service. */
    private final UserCrudService userService;

    /**  Local Constructor.
     * @param notificationService : @see NotificationCrudService.
     * @param userService : @see UserCrudService.*/
    public NotificationFixtureService(
            @Autowired  final NotificationCrudService notificationService,
            @Autowired final UserCrudService userService) {
        this.notificationService = notificationService;
        this.userService = userService;
    }

    /** Fixtures are loaded only if no data.
     * @throws NotFoundException : Notification entity not found.*/
    @Override
    protected void loadIfNoData() throws NotFoundException {

        this.build("Nouveau message de Pamwamba.",      userService.getOne(FixturesContract.FAB));
        this.build("Nouveau message de C-ambium.",      userService.getOne(FixturesContract.SAMY));
        this.build("Nouveau message de ListerKred.",    userService.getOne(FixturesContract.COLIN));

        for (int i = 1; i < FixturesContract.NB_REAL; i++) {
            this.build("Paul à accepté votre demande d'ami.",           userService.getOne(i));
            this.build("Jacques vous a envoyé une demande d'ami.",      userService.getOne(i));
            this.build("Votre demande d'inscritption à été validée.",   userService.getOne(i));
            this.build("Nouveau message de Paul.",                      userService.getOne(i));
            this.build("Nouvel évent à proximité",                      userService.getOne(i));
        }
    }

    /** Notification Builder function.
     * @param label : notification label.
     * @param user : notification user.*/
    private void build(final String label, final User user) {

        final Notification notification = new Notification();

        notification.setLabel(label);
        notification.setUser(user);

        notificationService.create(notification);
    }

}
