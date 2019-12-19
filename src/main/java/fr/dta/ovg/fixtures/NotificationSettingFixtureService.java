/** Notification Settings DB fixture service */
package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.dta.ovg.entities.NotificationSetting;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.NotificationSettingRepository;
import fr.dta.ovg.services.notification.NotificationSettingCrudService;

/** This class initialize DB with initials fixtures data. */
@Component
@Profile("!prod")
public class NotificationSettingFixtureService extends FixtureCheck<NotificationSettingRepository> {

    /** Declare local Notification Setting Service. */
    private final NotificationSettingCrudService notificationSettingService;

    /**
     * Local Constructor.
     *  Link to Notification Setting Service. */
    public NotificationSettingFixtureService(
            @Autowired final NotificationSettingCrudService notificationSettingService) {
        this.notificationSettingService = notificationSettingService;
    }

    /** Create-Drop DB - Insert initial data, erasing old data every run.
     * @throws NotFoundException */
    @Override
    protected void loadIfNoData() throws NotFoundException {
        this.build(false, false);
        this.build(false, true);
        this.build(true, false);
        this.build(true, true);

    }

    /**
     * The build function to create fixtures.
     * @param activeApp : the boolean that indicate if in-App notifications are activated
     * @param activeMail : the boolean that indicate if mail notifications are activated
     */
    private void build(final boolean activeApp, final boolean activeMail) {
        final NotificationSetting notificationSetting = new NotificationSetting();

        notificationSetting.setActiveApp(activeApp);
        notificationSetting.setActiveMail(activeMail);

        notificationSettingService.create(notificationSetting);
    }

}
