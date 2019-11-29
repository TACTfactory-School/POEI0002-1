package fr.dta.ovg.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "app_inscription")
public class Inscription extends EntityBase {

        private LocalDateTime startedAt;

        /** Le livreur doit-il installer le materiel. */
        @Column(nullable = false)
        private boolean valid = true;

        /** User inscription. */
        @ManyToOne(optional = false)
        private User user;

        /** Selected event. */
        @ManyToOne(optional = false)
        private Event event;



}
