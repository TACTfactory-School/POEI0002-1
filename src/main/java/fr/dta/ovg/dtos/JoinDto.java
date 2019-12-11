<<<<<<< HEAD
//package fr.dta.ovg.dtos;
//
//import java.time.LocalDateTime;
//
//import javax.validation.constraints.NotNull;
//
//public class JoinDto {
//
//    @NotNull
//    private LocalDateTime startedAt;
//
//    private boolean valid;
//
//    private long userId;
//
//    private long eventId;
//
//    /**
//     * @return the startedAt
//     */
//    public LocalDateTime getStartedAt() {
//        return startedAt;
//    }
//
//    /**
//     * @param startedAt the startedAt to set
//     */
//    public void setStartedAt(final LocalDateTime startedAt) {
//        this.startedAt = startedAt;
//    }
//
//    /**
//     * @return the valid
//     */
//    public boolean isValid() {
//        return valid;
//    }
//
//    /**
//     * @param valid the valid to set
//     */
//    public void setValid(final boolean valid) {
//        this.valid = valid;
//    }
//
//    /**
//     * @return the userId
//     */
//    public long getUserId() {
//        return userId;
//    }
//
//    /**
//     * @param userId the userId to set
//     */
//    public void setUserId(final long userId) {
//        this.userId = userId;
//    }
//
//    /**
//     * @return the eventId
//     */
//    public long getEventId() {
//        return eventId;
//    }
//
//    /**
//     * @param eventId the eventId to set
//     */
//    public void setEventId(final long eventId) {
//        this.eventId = eventId;
//    }
//
//}
=======
/* Join DTO Class.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class JoinDto {

    @NotNull
    private LocalDateTime startedAt;

    private boolean valid;

    private long userId;

    private long eventId;

    /**
     * Getter Started date.
     * @return the startedAt Date Time.
     */
    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    /**
     * Setter Started date.
     * @param startedAt the startedAt Date Time to set.
     */
    public void setStartedAt(final LocalDateTime startedAt) {
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
>>>>>>> 32a4893a2ee19df8d57b95af624321f552bae122
