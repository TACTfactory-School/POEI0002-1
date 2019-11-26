/**
 *
 */
package fr.dta.ovg.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.repositories.EventRepository;

/**
 * @author JoeHarms
 *
 */
@Component
@Transactional
public class EventCreateService {

      private static final Logger log = LoggerFactory.getLogger(EventCreateService.class);

        @Autowired
        private EventRepository repository;

        Event create(final Event event) {
            log.debug("Create employee");

            // Todo create (...) Upload avatar.

            return this.repository.save(event);
        }

}
