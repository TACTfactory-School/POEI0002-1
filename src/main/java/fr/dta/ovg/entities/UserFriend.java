/* User Friend class. Association table.
 * @author Colin Cerveaux @C-ambium.
 * Define Association table between User and User.
 * License : ©2019 All rights reserved.
 */

package fr.dta.ovg.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.dta.ovg.contracts.JsonIgnoreContract;
import io.swagger.annotations.ApiModelProperty;

/** User Friends class. Association table.*/
@Entity
@Table(name = "app_user_friends")
public class UserFriend extends EntityBase {

    /** Validation of event inscription request.*/
    @Column(name = "us_fr_valid", unique = false, nullable = false)
    @ApiModelProperty(value = "Join table between user and user.")
    private boolean valid = true;

    /** Validation of event inscription request.*/
    @Column(name = "us_fr_validate_at", unique = false, nullable = true)
    @ApiModelProperty(value = "Validation date of friend add.")
    private LocalDateTime validatedAt;

    /** Selected user. */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({
        JsonIgnoreContract.USER_FRIENDS_ACCEPT,
        JsonIgnoreContract.HOBBIES,
        JsonIgnoreContract.JOIN_EVENTS,
        JsonIgnoreContract.NOTIFICATIONS,
        JsonIgnoreContract.MESSAGES_EMITTED,
        JsonIgnoreContract.MESSAGES_RECEIVED,
        JsonIgnoreContract.LANGUAGES})
    private User friendRequest;

    /** Selected Hobby. */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({
        JsonIgnoreContract.USER_FRIENDS_REQUEST,
        JsonIgnoreContract.HOBBIES,
        JsonIgnoreContract.JOIN_EVENTS,
        JsonIgnoreContract.NOTIFICATIONS,
        JsonIgnoreContract.MESSAGES_EMITTED,
        JsonIgnoreContract.MESSAGES_RECEIVED,
        JsonIgnoreContract.LANGUAGES})
    private User friendAccept;

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

    /** Get the requested friend user.
     * @return the friendRequest.*/
    public User getFriendRequest() {
        return friendRequest;
    }

    /** Set the requested friend user.
     * @param friendRequest : the friendRequest to set.*/
    public void setFriendRequest(final User friendRequest) {
        if (this.friendRequest != friendRequest) {
            this.friendRequest = friendRequest;
            if (friendRequest != null) {
                friendRequest.addFriendRequest(this);
            }
        }
    }

    /** Get the accepted friend user.
     * @return the friendAccept.*/
    public User getFriendAccept() {
        return friendAccept;
    }

    /** Set the accepted friend user.
     * @param friendAccept : the friendAccept to set.*/
    public void setFriendAccept(final User friendAccept) {
        if (this.friendAccept != friendAccept) {
            this.friendAccept = friendAccept;
            if (friendAccept != null) {
                friendAccept.addFriendAccept(this);
            }
        }
    }
}
