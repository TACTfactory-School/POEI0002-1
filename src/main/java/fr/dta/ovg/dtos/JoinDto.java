/* Join DTO Class.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.dtos;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;

public class JoinDto {

    @NotNull
    private ZonedDateTime startedAt;

    private boolean valid;

    private long userId;

    private long eventId;

    /**
     * Getter Started date.
     * @return the startedAt Date Time.
     */
    public ZonedDateTime getStartedAt() {
        return startedAt;
    }

    /**
     * Setter Started date.
     * @param startedAt the startedAt Date Time to set.
     */
    public void setStartedAt(final ZonedDateTime startedAt) {
        this.startedAt = startedAt;
    }

    /**
     * Getter isValid.
     * @return the valid boolean.
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * Setter Valid boolean.
     * @param valid the valid boolean to set.
     */
    public void setValid(final boolean valid) {
        this.valid = valid;
    }

    /**
     * Getter User id.
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Setter User id.
     * @param userId the userId to set
     */
    public void setUserId(final long userId) {
        this.userId = userId;
    }

    /** Getter Event id.
     * @return the eventId.
     */
    public long getEventId() {
        return eventId;
    }

    /**
     * Setter Event id.
     * @param eventId the eventId to set.
     */
    public void setEventId(final long eventId) {
        this.eventId = eventId;
    }

}
