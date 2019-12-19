/* Entity Event class.
 * @author Colin Cerveaux @C-ambium.
 * Define the entity Event.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.dta.ovg.contracts.EventContract;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Entity Event class.*/
@Entity
@Table(name = EventContract.TABLE)
@ApiModel(value = EventContract.TABLE_API)
public class Event extends EntityBase {

    /** Creator of the Event. <br>DB Column.*/
    // TODO : Restore @NotBlank when DB run in update mode.
    @ApiModelProperty(value = EventContract.COL_CREATOR_API)
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({"joinEvents", "notifications", "languages", "hobbies", "friends", "messagesEmitted",
        "messagesReceived"})
    private User creator;

    /** Title of the Event. <br>DB Column.*/
    @NotBlank
    @ApiModelProperty(value = EventContract.COL_LABEL_API)
    @Column(name = EventContract.COL_LABEL, length = 100, nullable = false, unique = false)
    private String label;

    /** Description of the Event. <br>DB Column.*/
    @ApiModelProperty(value = EventContract.COL_DESC_API)
    @Column(name = EventContract.COL_DESC, length = 510, nullable = true, unique = false)
    private String description;

    /** The started date/time of the Event. <br> DB Column.*/
    @ApiModelProperty(value = EventContract.COL_START_DATE_API)
    @Column(name = EventContract.COL_START_DATE, nullable = false, unique = false)
    private ZonedDateTime startAt;

    /** Custom photo of the Event. <br>DB Column.*/
    @ApiModelProperty(value = EventContract.COL_IMG_API)
    @Column(name = EventContract.COL_IMG, length = 255, nullable = true, unique = false)
    private String img;

    /** Max places of the Event. <br>DB Column.*/
    @ApiModelProperty(value = EventContract.COL_NB_PLACES_API)
    @Column(name = EventContract.COL_NB_PLACES, nullable = true, unique = false) // false
    private int nbPlaceMax;

    /** Address of the Event. <br>DB Column.*/
    @ApiModelProperty(value = EventContract.COL_ADDRESS_API)
    @Column(name = EventContract.COL_ADDRESS, length = 255, nullable = true, unique = false)
    private String address;

    /**
     * City postcode of the Event. <br>DB Column.*/
    @ApiModelProperty(value = EventContract.COL_POSTCODE_API)
    @Column(name = EventContract.COL_POSTCODE, nullable = true, unique = false)
    private String postcode;

    /** City of the Event. <br>DB Column.*/
    @NotBlank
    @ApiModelProperty(value = EventContract.COL_CITY_API)
    @Column(name = EventContract.COL_CITY, length = 255, nullable = false, unique = false)
    private String city;

    /** Type of the Event. <br>DB Column.*/
    @ApiModelProperty(value = EventContract.COL_TYPE_API)
    @Column(name = EventContract.COL_TYPE, length = 255, nullable = true, unique = false)
    @Enumerated(EnumType.ORDINAL)
    private EventType type;

    /** Join users List of the Event. <br>DB Column.*/
    @OneToMany(mappedBy = EventContract.MAPPED_BY, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"event"}, allowSetters = true)
    private final List<JoinEvent> usersJoin = new ArrayList<>();

    /** Notifications List of the Event. <br>DB Column.*/
    @OneToMany(mappedBy = EventContract.MAPPED_BY, fetch = FetchType.LAZY)
//    @JsonIgnoreProperties("event")
//    @JsonIgnore
    private final List<Notification> eventNotification = new ArrayList<>();

    /** Messages List of the Event. <br>DB Column.*/
    @OneToMany(mappedBy = EventContract.MAPPED_BY)
//    @JsonIgnoreProperties("event")
//    @JsonIgnore
    private final List<Message> messages = new ArrayList<>();

    /** Override toString() method with Event attributes.*/
    @Override
    public String toString() {

        return String.format(EventContract.TO_STRING,
                label, description, creator, isEnabled(), startAt, nbPlaceMax, address, postcode, city);
    }

    /**
     * Getter type of event.
     * @return the type (EventType Enum).
     */
    public EventType getType() {
        return type;
    }

    /**
     * Setter type of event.
     * @param type (EventType Enum) : the type to set.
     */
    public void setType(final EventType type) {
        this.type = type;
    }

    /**
     * Getter started date time.
     * @return the startedAt (ZoneDateTime).
     */
    public ZonedDateTime getStartAt() {
        return startAt;
    }

    /**
     * Setter started date time.
     * @param startedAt (ZonedDateTime) : the startedAt to set.
     */
    public void setStartAt(final ZonedDateTime startedAt) {
        this.startAt = startedAt;
    }

    /**
     * Getter the img mock.
     * @return the img (String).
     */
    public String getImg() {
        return img;
    }

    /**
     * Setter img mock.
     * @param img (String) : the img to set.
     */
    public void setImg(final String img) {
        this.img = img;
    }

    /**
     * Getter max places of the event.
     * @return the nbPlaceMax (int).
     */
    public int getNbPlaceMax() {
        return nbPlaceMax;
    }

    /**
     * Setter max places of the event.
     * @param nbPlaceMax (int) : the nbPlaceMax to set.
     */
    public void setNbPlaceMax(final int nbPlaceMax) {
        this.nbPlaceMax = nbPlaceMax;
    }

    /**
     * Getter address.
     * @return the address (String).
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter address.
     * @param address (String) : the address to set.
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * Getter Postcode.
     * @return the postcode (String).
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Setter Postcode.
     * @param postcode (String) : the postcode to set.
     */
    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }

    /**
     * Getter city.
     * @return the city (String).
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter city.
     * @param city (String) the city to set.
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * Getter Label/Title.
     * @return label (String) : the label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter Label/Title.
     * @param label (String) : label to set.
     */
    public void setLabel(final String label) {
        this.label = label;
    }

    /**
     * Getter Description.
     * @return description  (String) : the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter Description.
     * @param description  (String) : the description to set.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Getter Creator.
     * @return creator (String) : the User creator.
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Setter Creator.
     * @param creator : the (User) creator to set.
     */
    public void setCreator(final User creator) {
        this.creator = creator;
    }

    /**
     * Getter List of join users.
     * @return all users who have requested to join event.
     */
    public List<JoinEvent> getUsersJoin() {
        return usersJoin;
    }

    /**
     * Get notifications list.
     * @return the eventNotification : List of notification.
     */
    public List<Notification> getEventNotification() {
        return eventNotification;
    }

    /**
     *  Get messages list.
     * @return the messages : List of messages.
     */
    public List<Message> getMessages() {
        return messages;
    }


    /**
     * Function - Add notification to Event.
     * @param eventNotification : Notification.
     */
    public void addEventNotification(final Notification eventNotification) {
        if (!this.eventNotification.contains(eventNotification)) {
            this.eventNotification.add(eventNotification);
            eventNotification.setEvent(this);
        }
    }

    /**
     * Function - Add Join Event.
     * @param usersJoin : JoinEvent.
     */
    public void addJoinEvent(final JoinEvent usersJoin) {
        if (!this.usersJoin.contains(usersJoin)) {
            this.usersJoin.add(usersJoin);
            usersJoin.setEvent(this);
        }
    }

    /**
     * Function - Add message to Event.
     * @param message : Message.
     */
    public void addEventMessage(final Message message) {
        if (!this.messages.contains(message)) {
            this.messages.add(message);
            message.setEvent(this);
        }
    }

    /**
     * Function - Remove notification to Event.
     * @param eventNotification : Notification.
     */
    public void removeEventNotification(final Notification eventNotification) {
        if (this.eventNotification.contains(eventNotification)) {
            this.eventNotification.remove(eventNotification);
        }
    }

    /**
     * Function - Remove Join Event.
     * @param usersJoin : JoinEvent.
     */
    public void removeJoinEvent(final JoinEvent usersJoin) {
        if (this.usersJoin.contains(usersJoin)) {
            this.usersJoin.remove(usersJoin);
        }
    }

    /**
     * Function - Remove Event message.
     * @param message :Message.
     */
    public void removeEventMessage(final Message message) {
        if (this.messages.contains(message)) {
            this.messages.remove(message);
        }
    }

}
