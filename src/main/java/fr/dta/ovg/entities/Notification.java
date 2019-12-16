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
}
