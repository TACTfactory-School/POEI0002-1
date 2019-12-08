package fr.dta.ovg.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.dta.ovg.security.entities.SecurityUser;

@Entity
@Table(name = "app_join")
public class Join extends EntityBase {

        private LocalDateTime startedAt;

        /** Le livreur doit-il installer le materiel. */
        @Column(nullable = false)
        private boolean valid = true;

        /** User inscription. */
        @ManyToOne(targetEntity = Event.class, optional = false)
        private SecurityUser user;

        /** Selected event. */
        @ManyToOne(targetEntity = User.class, optional = false)
        private Event event;

        /**
         * @return the startedAt
         */
        public LocalDateTime getStartedAt() {
            return startedAt;
        }

        /**
         * @param startedAt the startedAt to set
         */
        public void setStartedAt(LocalDateTime startedAt) {
            this.startedAt = startedAt;
        }

        /**
         * @return the valid
         */
        public boolean isValid() {
            return valid;
        }

        /**
         * @param valid the valid to set
         */
        public void setValid(boolean valid) {
            this.valid = valid;
        }

        /**
         * @return the user
         */
        public SecurityUser getUser() {
            return user;
        }

        /**
         * @param user the user to set
         */
        public void setUser(SecurityUser user) {
            this.user = user;
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
        public void setEvent(Event event) {
            this.event = event;
        }

}
