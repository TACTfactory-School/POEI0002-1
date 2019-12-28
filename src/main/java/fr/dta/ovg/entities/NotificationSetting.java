/* Entity NotificationSetting  class.
 * @author Colin Cerveaux @C-ambium.
 * Define the user notification settings.
 * License : ©2019 All rights reserved.
 */

package fr.dta.ovg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import fr.dta.ovg.contracts.SettingContract;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Entity NotificationSetting  class.*/
@Entity
@Table(name = SettingContract.TABLE)
@ApiModel(value = SettingContract.TABLE_API)
public class NotificationSetting extends EntityBase {

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    /** Application notifications setting. <br>DB Column.*/
    @Column(name = SettingContract.COL_ACTIVE_APP, nullable = false, unique = false)
    @ApiModelProperty(value = SettingContract.COL_ACTIVE_APP_API)
    private boolean activeApp;

    /** Mail notifications setting. <br>DB Column.*/
    @Column(name = SettingContract.COL_ACTIVE_MAIL, nullable = false, unique = false)
    @ApiModelProperty(value = SettingContract.COL_ACTIVE_MAIL_API)
    private boolean activeMail;

    /** Get application Notification setting.
     * @return the hideApp (boolean) : Application notification setting.*/
    public boolean isActiveApp() {
        return activeApp;
    }

    /** Set Application Notification setting.
     * @param activeApp : boolean to set (boolean) : Enable/Disable application notifications.*/
    public void setActiveApp(final boolean activeApp) {
        this.activeApp = activeApp;
    }

    /** Get Mail Notification setting.
     * @return the activeMail (boolean) : Mail notification settings.*/
    public boolean isActiveMail() {
        return activeMail;
    }

    /** Set Mail Notification setting.
     * @param activeMail : boolean to set. Enable/Disable mail notifications.*/
    public void setActiveMail(final boolean activeMail) {
        this.activeMail = activeMail;
    }
}
