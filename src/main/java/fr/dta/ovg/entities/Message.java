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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "app_messages")
@ApiModel(value = "Describes a Message for our system")
public class Message extends EntityBase {

    @NotBlank
    @Column(name = "mess_label", length = 500, nullable = false, unique = false)
    @ApiModelProperty(value = "The message to send.")
    private String message;

    @ManyToOne
    private User userEmitter;

    @ManyToOne
    private User userReceiver;

    @ManyToOne
    private Event event;

    /**
     * Getter Message.
     * @return the message (String).
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the userEmitter
     */
    public User getUserEmitter() {
        return userEmitter;
    }

    /**
     * @param userEmitter the userEmitter to set
     */
    public void setUserEmitter(final User userEmitter) {
        if (this.userEmitter != userEmitter) {
            this.userEmitter = userEmitter;
            if (userEmitter != null) {
                userEmitter.addEmmitedMessage(this);
            }
        }
    }

    /**
     * @return the userReceiver
     */
    public User getUserReceiver() {
        return userReceiver;
    }

    /**
     * @param userReceiver the userReceiver to set
     */
    public void setUserReceiver(final User userReceiver) {
        if (this.userReceiver != userReceiver) {
            this.userReceiver = userReceiver;
            if (userReceiver != null) {
                userReceiver.addReceivedMessage(this);
            }
        }
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(final Event event) {
        if (this.event != event) {
            this.event = event;
            if (event != null) {
                event.addEventMessage(this);
            }
        }
    }

    /**
     * @param message the message to set
     */
    public void setMessage(final String message) {
        this.message = message;
    }

}
