/* Entity Event class.
 * @author Colin Cerveaux @C-ambium
 * Define the entity Event
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "app_events")
@ApiModel(value = "Describes an Event for our system")
public class Event extends EntityBase {

        /** Title of the Event <br> DB Column */
        @NotBlank
        @Column(length = 100, nullable = false, unique = false)
        @ApiModelProperty(value = "The label of the event")
        private String label;

        /** Description of the Event <br> DB Column */
        @Column(name = "event_description", length = 255, nullable = true, unique = false)
        @ApiModelProperty(value = "The description of the event")
        private String description;

        /** Author of the Event <br> DB Column */
        @NotBlank
        @Column(name = "author", length = 50, nullable = false, unique = true)
        @ApiModelProperty(value = "The author of the event")
        private String author;

        @ManyToMany
        @JoinTable(
            name = "app_event_users",
            joinColumns = {@JoinColumn(name = "app_users.id")},
            inverseJoinColumns = { @JoinColumn(name = "app_events.id") })
        private List<User> users;

        /** Override toString() method with Event attributes */
        @Override
        public String toString() {
            return String.format("| Title : %s | Description : %s | Author : %s",
                    label, description, author);
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
        public void setLabel(String label) {
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
        public void setDescription(String description) {
            this.description = description;
        }
        /**
         * Getter Author.
         * @return String : the author.
         */
        public String getAuthor() {
            return author;
        }

        /**
         * Setter Author.
         * @param String author : the author to set.
         */
        public void setAuthor(String author) {
            this.author = author;
        }
}
