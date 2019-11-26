package fr.dta.ovg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "app_events")
public class Event extends EntityBase {

        @Column(length = 100, nullable = false, unique = true)
        @NotBlank
        private String label;

        @Column(name = "event_description", length = 255, nullable = true, unique = false)
        private String description;

        @Column(name = "author", length = 50, nullable = false, unique = true)
        @NotBlank
        private String author;

        @Override
        public String toString() {
            return String.format("| Title : %s | Description : %s | Author : %s",
                    label, description, author);
        }
        /**
         * @return the label
         */
        public String getLabel() {
            return label;
        }

        /**
         * @param label label to set
         */
        public void setLabel(String label) {
            this.label = label;
        }

        /**
         * @return the description
         */
        public String getDescription() {
            return description;
        }

        /**
         * @param description the description to set
         */
        public void setDescription(String description) {
            this.description = description;
        }
        /**
         * @return the author
         */
        public String getAuthor() {
            return author;
        }

        /**
         * @param author the author to set
         */
        public void setAuthor(String author) {
            this.author = author;
        }
}
