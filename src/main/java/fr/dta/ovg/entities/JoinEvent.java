/* Join Event class. Association table.
 * @author Colin Cerveaux @C-ambium.
 * Define Association table between User and Event.
 * License : ©2019 All rights reserved.
 */

package fr.dta.ovg.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/** Join Event class. Association table between User and Event.*/
@Entity
@Table(name = "app_join_event") //, uniqueConstraints = {@UniqueConstraint(columnNames={"user", "event"})})
public class JoinEvent extends EntityBase {

    /** Validation of event inscription request. */
    @Column(name = "us_ev_valid", unique = false, nullable = false)
    private boolean valid = true;

    /** Validation of event inscription request. */
    @Column(name = "us_ev_validatedAt", unique = false, nullable = false)
    private LocalDateTime validatedAt;

    /**
     * Event Role of user. <br> DB Column.*/
    @Column(name = "us_ev_role", unique = false, nullable = false)
    @ApiModelProperty(value = "The Role of the user in the Event.")
    @Enumerated(EnumType.ORDINAL)
    private EventRole role;
 //   @Transient


    /** User inscription. */
    @ManyToOne(optional = false) // targetEntity = Event.class
    @JoinColumn(nullable = false)
    private User user;

    /** Selected event. */
    @ManyToOne(optional = false) // targetEntity = User.class
    @JoinColumn(nullable = false)
    private Event event;

    /** Get the role.
     * @return the role : Enum EventRole.*/
    public EventRole getRole() {
        return role;
    }

    /** Set role.
     * @param role the role to set.*/
    public void setRole(final EventRole role) {
        this.role = role;
    }

    /** Get valid.
     * @return valid : is valid boolean.*/
    public boolean isValid() {
        return valid;
    }

    /** Set Valid - assign validated Date.
     * @param valid : the valid to set.*/
    public void setValid(final boolean valid) {
        this.valid = valid;

        if (this.valid) {
            this.validatedAt = LocalDateTime.now();
        }
    }

    /** Get the Join User.
     * @return the user : User.*/
    public User getUser() {
        return user;
    }

    /** Set the Join User.
     * @param user the user to set.*/
    public void setUser(final User user) {
        if (this.user != user) {
            this.user = user;

            if (user != null) {
                user.addJoinEvent(this);
            }
        }
    }

    /** Get the Join Event.
     * @return the event : Event.*/
    public Event getEvent() {
        return event;
    }

    /** Set the Join Event.
     * @param event the event to set.*/
    public void setEvent(final Event event) {
        if (this.event != event) {
            this.event = event;
            if (event != null) {
                event.addJoinEvent(this);
            }
        }
    }

    /** Get the join Validated Date.
     * @return the validatedAt : LocalDateTime.
     */
    public LocalDateTime getValidatedAt() {
        return validatedAt;
    }

    /** Set the join Validated Date.
     * @param validatedA the validatedA to set.*/
    public void setValidatedAt(final LocalDateTime validatedA) {
        this.validatedAt = validatedA;
    }

}
