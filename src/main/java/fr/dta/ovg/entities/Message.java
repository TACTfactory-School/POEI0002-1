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
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(final String message) {
        this.message = message;
    }
}
