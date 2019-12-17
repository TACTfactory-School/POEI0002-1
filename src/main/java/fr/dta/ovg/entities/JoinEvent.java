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

    /**
     * @return the role.
     */
    public EventRole getRole() {
        return role;
    }

    /**
     * @param role the role to set.
     */
    public void setRole(final EventRole role) {
        this.role = role;
    }

    /**
     * @return the valid.
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * @param valid
     *            the valid to set.
     */
    public void setValid(final boolean valid) {
        this.valid = valid;

        if (this.valid == true) {
            this.validatedAt = LocalDateTime.now();
        }
    }

    /**
     * @return the user.
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user
     *            the user to set.
     */
    public void setUser(final User user) {
        if (this.user != user) {
            this.user = user;
            if (user != null) {
                user.addJoinEvent(this);
            }
        }
    }

    /**
     * @return the event.
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event
     *            the event to set.
     */
    public void setEvent(final Event event) {
        if (this.event != event) {
            this.event = event;
            if (event != null) {
                event.addJoinEvent(this);
            }
        }
    }

    /**
     * @return the validatedA
     */
    public LocalDateTime getValidatedAt() {
        return validatedAt;
    }

    /**
     * @param validatedA the validatedA to set
     */
    public void setValidatedAt(final LocalDateTime validatedA) {
        this.validatedAt = validatedA;
    }

}
