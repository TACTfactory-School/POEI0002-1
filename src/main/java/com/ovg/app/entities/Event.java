package com.ovg.app.entities;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

        @JsonProperty
        private Integer id;

        private String label;

        private String description;

        private String author;


        public Event() {
            this(null, null, null, null);
        }

        public Event(final Integer id, final String label, final String description,  final String author) {
            this.id = id;
            this.label = label;
            this.description = description;
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("ID : %d | Title : %s | Description : %s | Author : %s",
                    id, label, description, author);
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
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
