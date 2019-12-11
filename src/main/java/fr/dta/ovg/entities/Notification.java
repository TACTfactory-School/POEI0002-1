/* Entity Notification class.
 * @author Colin Cerveaux @C-ambium.
 * Define the entity Notification.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "app_notifications")
@ApiModel(value = "Describes a Notification for our system")
public class Notification extends EntityBase {

    private String label;

    private boolean app;

    private boolean mail;

    /**
     * Getter label.
     * @return the label (String).
     */
    public String getLabel() {
        return label;
    }

    /** Setter Label.
     * @param label (String) : the label to set
     */
    public void setLabel(final String label) {
        this.label = label;
    }

    /**
     * Get Boolean preference application notification.
     * @return the app (boolean).
     */
    public boolean isApp() {
        return app;
    }
    /**
     * Set Boolean preference application notification.
     * @param app (boolean) :the app to set.
     */
    public void setApp(final boolean app) {
        this.app = app;
    }

    /**
     * Get Boolean preference mail notification.
     * @return the mail
     */
    public boolean isMail() {
        return mail;
    }
    /**
     * Set Boolean preference mail notification.
     * @param mail (boolean) : the mail to set.
     */
    public void setMail(final boolean mail) {
        this.mail = mail;
    }
}
