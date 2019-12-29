/* Entity Message class.
 * @author Colin Cerveaux @C-ambium.
 * Define the entity Message.
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
import fr.dta.ovg.contracts.MessageContract;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Entity Message class.*/
@Entity
@Table(name = MessageContract.TABLE)
@ApiModel(value = MessageContract.TABLE_API)
public class Message extends EntityBase {

    /** Message String container. <br>DB Column.*/
    @NotBlank
    @Column(name = MessageContract.COL_LABEL,
            length = MessageContract.COL_LABEL_LENGTH, nullable = false, unique = false)
    @ApiModelProperty(value = MessageContract.COL_LABEL_API)
    private String message;

    /** Join Table UserEmitter. <br>DB Column.*/
    @ManyToOne
    @JsonIgnoreProperties({
        JsonIgnoreContract.JOIN_EVENTS,
        JsonIgnoreContract.NOTIFICATIONS,
        JsonIgnoreContract.LANGUAGES,
        JsonIgnoreContract.HOBBIES,
        JsonIgnoreContract.USER_FRIENDS_ACCEPT,
        JsonIgnoreContract.USER_FRIENDS_REQUEST,
        JsonIgnoreContract.MESSAGES_EMITTED,
        JsonIgnoreContract.MESSAGES_RECEIVED,
        JsonIgnoreContract.PREFERENCES})
    private User userEmitter;

    /** Join Table UserReceiver. <br>DB Column.*/
    @ManyToOne
    @JsonIgnore
    private User userReceiver;

    /** Join Table Event. <br>DB Column.*/
    @ManyToOne
    @JsonIgnore
    private Event event;

    /** Getter Message.
     * @return the message (String).*/
    public String getMessage() {
        return message;
    }

    /** Get the user emitter.
     * @return the userEmitter : User.*/
    public User getUserEmitter() {
        return userEmitter;
    }

    /** Set the user emitter.
     * @param userEmitter the userEmitter to set.*/
    public void setUserEmitter(final User userEmitter) {
        if (this.userEmitter != userEmitter) {
            this.userEmitter = userEmitter;
            if (userEmitter != null) {
                userEmitter.addEmmittedMessage(this);
            }
        }
    }

    /** Get the user receiver.
     * @return the userReceiver : User.*/
    public User getUserReceiver() {
        return userReceiver;
    }

    /** Set the user receiver.
     * @param userReceiver the userReceiver to set.*/
    public void setUserReceiver(final User userReceiver) {
        if (this.userReceiver != userReceiver) {
            this.userReceiver = userReceiver;
            if (userReceiver != null) {
                userReceiver.addReceivedMessage(this);
            }
        }
    }

    /** Get the event.
     * @return the event : Event.*/
    public Event getEvent() {
        return event;
    }

    /** Set the event.
     * @param event the Event to set.*/
    public void setEvent(final Event event) {
        if (this.event != event) {
            this.event = event;
            if (event != null) {
                event.addEventMessage(this);
            }
        }
    }

    /** Set Message.
     * @param message the message to set.*/
    public void setMessage(final String message) {
        this.message = message;
    }

}
