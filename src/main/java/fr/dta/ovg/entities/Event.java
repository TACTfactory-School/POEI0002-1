/* Entity Event class.
 * @author Colin Cerveaux @C-ambium
 * Define the entity Event
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "app_events")
public class Event extends EntityBase {

        /** Title of the Event <br> DB Column */
        @Column(length = 100, nullable = false, unique = true)
        @NotBlank
        private String label;

        /** Description of the Event <br> DB Column */
        @Column(name = "event_description", length = 255, nullable = true, unique = false)
        private String description;

        /** Author of the Event <br> DB Column */
        @Column(name = "author", length = 50, nullable = false, unique = true)
        @NotBlank
        private String author;

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
