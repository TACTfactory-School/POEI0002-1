/* Entity Notification class.
 * @author Colin Cerveaux @C-ambium.
 * Define the entity Notification.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.dta.ovg.contracts.JsonIgnoreContract;
import fr.dta.ovg.contracts.NotificationContract;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/** Entity Notification class.*/
@Entity
@Table(name = NotificationContract.TABLE)
@ApiModel(value = NotificationContract.TABLE_API)
public class Notification extends EntityBase {

    /** Label of the Notification. <br>DB Column.*/
    @NotBlank
    @Column(name = NotificationContract.COL_LABEL,
            length = NotificationContract.COL_LABEL_LENGTH,
            nullable = false, unique = false)
    @ApiModelProperty(value = NotificationContract.COL_LABEL_API)
    private String label;

    /** Join Table User.*/
    @ManyToOne
    @JsonIgnore
    private User user;

    /** Join Table Event.*/
    @ManyToOne
    @JsonIgnoreProperties({
        JsonIgnoreContract.MESSAGES,
        JsonIgnoreContract.JOIN_USERS,
        JsonIgnoreContract.NOTIFICATIONS})
    private Event event;

    /** Getter label.
     * @return the label (String).*/
    public String getLabel() {
        return label;
    }

    /** Setter Label.
     * @param label (String) : the label to set.*/
    public void setLabel(final String label) {
        this.label = label;
    }

    /** Get the user of notification.
     * @return the user : User.*/
    public User getUser() {
        return user;
    }

    /** Set the user of notification.
     * @param user the user to set.*/
    public void setUser(final User user) {
        if (this.user != user) {
            this.user = user;
            if (user != null) {
                user.addUserNotification(this);
            }
        }
    }

    /** Get the event of notification.
     * @return the event : Event.*/
    public Event getEvent() {
        return event;
    }

    /** Set the event of notification.
     * @param event the event to set.*/
    public void setEvent(final Event event) {
        if (this.event != event) {
            this.event = event;
            if (event != null) {
                event.addEventNotification(this);
            }
        }
    }

}
