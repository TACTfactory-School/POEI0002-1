/* Entity Event class.
 * @author Colin Cerveaux @C-ambium
 * Define the entity Event
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "app_events")
@ApiModel(value = "Describes an Event for our system")
public class Event extends EntityBase {


    //  @NotBlank
    //  @Column(name = "ev_author", length = 50, nullable = false, unique = true)
    /** Author of the Event <br> DB Column */
        @ApiModelProperty(value = "The author of the event")
        @ManyToOne(optional = false)
        private User creator;

        /** Title of the Event <br> DB Column */
        @NotBlank
        @Column(name = "ev_title", length = 100, nullable = false, unique = false)
        @ApiModelProperty(value = "The label of the event")
        private String label;

        /** Description of the Event <br> DB Column */
        @Column(name = "ev_description", length = 510, nullable = true, unique = false)
        @ApiModelProperty(value = "The description of the event")
        private String description;

        /** The started date/time of the Event <br> DB Column */
        @ApiModelProperty(value = "The started time date of the event")
        @Column(nullable = false)
        private LocalDateTime startAt;

        /** Custom photo of the Event <br> DB Column */
        @ApiModelProperty(value = "The custom picture of the event")
        @Column(length = 255, nullable = true)
        private String img;

        /** Max places of the Event <br> DB Column */
        @ApiModelProperty(value = "Th max places amount of the event")
        @Column(nullable = true) // false
        private int nbPlaceMax;

        /** Address of the Event <br> DB Column */
        @ApiModelProperty(value = "The place of the event")
        @Column(length = 255, nullable = true)
        private String address;

        /** City postcode of the Event <br> DB Column */
        @ApiModelProperty(value = "The city postcode of the event")
        @Column(nullable = true)
        private String postcode;

        /** City of the Event <br> DB Column */
        @NotBlank
        @ApiModelProperty(value = "The city of the event")
        @Column(length = 255, nullable = true) // false
        private String city;

//        /** Participants of the Event <br> DB Mapped By */
//        @ManyToMany(mappedBy = "events")
//        private List<User> usersEnrolled;
//
//        /** Pending users to join the Event <br> DB Mapped By */
//        @ManyToMany(mappedBy = "events")
//        private List<User> usersPending;
//
//        /** Organizers of the Event <br> DB Mapped By */
//        @ManyToMany(mappedBy = "ev_organizers")
//        private List<User> organizers;


        @ManyToMany
        @JoinTable(
                joinColumns = {@JoinColumn(name = "app_users.id")},
                inverseJoinColumns = { @JoinColumn(name = "app_events.id") })
            private List<User> users;

        /** Override toString() method with Event attributes */
        @Override
        public String toString() {
            return String.format("| Title : %s | Description : %s | Author : %s",
                    label, description, creator);
        }

        /**
         * @return the startedAt
         */
        public LocalDateTime getStartAt() {
            return startAt;
        }

        /**
         * @param startedAt the startedAt to set
         */
        public void setStartAt(final LocalDateTime startedAt) {
            this.startAt = startedAt;
        }

        /**
         * @return the img
         */
        public String getImg() {
            return img;
        }

        /**
         * @param img the img to set
         */
        public void setImg(final String img) {
            this.img = img;
        }

        /**
         * @return the nbPlaceMax
         */
        public int getNbPlaceMax() {
            return nbPlaceMax;
        }

        /**
         * @param nbPlaceMax the nbPlaceMax to set
         */
        public final void setNbPlaceMax(final int nbPlaceMax) {
            this.nbPlaceMax = nbPlaceMax;
        }

        /**
         * @return the address
         */
        public String getAddress() {
            return address;
        }

        /**
         * @param address the address to set
         */
        public void setAddress(final String address) {
            this.address = address;
        }

        /**
         * @return the postcode
         */
        public String getPostcode() {
            return postcode;
        }

        /**
         * @param postcode the postcode to set
         */
        public void setPostcode(final String postcode) {
            this.postcode = postcode;
        }

        /**
         * @return the city
         */
        public String getCity() {
            return city;
        }

        /**
         * @param city the city to set
         */
        public void setCity(final String city) {
            this.city = city;
        }

        /**
         * Getter Label.
         * @return String : the label.
         */
        public String getLabel() {
            return label;
        }

        /**
         * Setter Label.
         * @param String label : label to set.
         */
        public void setLabel(final String label) {
            this.label = label;
        }

        /**
         * Getter Description.
         * @return String : the description.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Setter Description.
         * @param String description : the description to set.
         */
        public void setDescription(final String description) {
            this.description = description;
        }
        /**
         * Getter Author.
         * @return String : the author.
         */
        public User getCreator() {
            return creator;
        }

        /**
         * Setter Author.
         * @param String author : the author to set.
         */
        public void setCreator(final User author) {
            this.creator = author;
        }
}
