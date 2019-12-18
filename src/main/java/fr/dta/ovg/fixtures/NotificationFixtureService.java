package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.entities.Notification;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.NotificationRepository;
import fr.dta.ovg.services.NotificationCrudService;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class NotificationFixtureService extends FixtureCheck<NotificationRepository> {

    private final NotificationCrudService notificationService;

    public NotificationFixtureService(@Autowired  final NotificationCrudService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    protected void loadIfNoData() throws NotFoundException {
        this.build("Votre demande d'inscritption à été validée.");
        this.build("Nouveau message de Pamwamba.");
        this.build("Nouveau message de C-ambium.");
        this.build("Nouveau message de ListerKred.");
        this.build("Nouveau message de Paul.");
        this.build("Nouvel évent à proximité");
        this.build("Paul à accepté votre demande d'ami.");
        this.build("Jacques vous a envoyé une demande d'ami.");

    }

    private void build(final String label) {

        final Notification notification = new Notification();

        notification.setLabel(label);

        notificationService.create(notification);
    }

}
