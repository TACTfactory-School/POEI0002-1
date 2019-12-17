/* Entity NotificationSetting  class.
 * @author Colin Cerveaux @C-ambium.
 * Define the user notification settings.
 * License : ©2019 All rights reserved.
 */

package fr.dta.ovg.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

/** Entity NotificationSetting  class.*/
@Entity
@Table(name = "app_settings")
@ApiModel(value = "Describes Notification settings for our system")
public class NotificationSetting extends EntityBase {

    private boolean activeApp;

    private boolean activeMail;

    /** Get application Notification setting.
     * @return the hideApp (boolean) : Application notification setting.*/
    public boolean isActiveApp() {
        return activeApp;
    }

    /** Set Application Notification setting.
     * @param hideApp the hideApp to set (boolean) : Enable/Disable application notifications.*/
    public void setActiveApp(final boolean activeApp) {
        this.activeApp = activeApp;
    }

    /** Get Mail Notification setting.
     * @return the hideMail (boolean) : Mail notification settings.*/
    public boolean isActiveMail() {
        return activeMail;
    }

    /** Set Mail Notification setting.
     * @param hideMail the hideMail to set (boolean) : Enable/Disable mail notifications.*/
    public void setActiveMail(final boolean activeMail) {
        this.activeMail = activeMail;
    }
}
