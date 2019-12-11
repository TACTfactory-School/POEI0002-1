/* Entity Message class.
 * @author Colin Cerveaux @C-ambium.
 * Define the entity Message.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "app_messages")
@ApiModel(value = "Describes a Message for our system")
public class Message extends EntityBase {

    private String message;

    /**
     * Getter Message.
     * @return the message (String).
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter Message.
     * @param message  (String) : the message to set.
     */
    public void setMessage(final String message) {
        this.message = message;
    }
}
