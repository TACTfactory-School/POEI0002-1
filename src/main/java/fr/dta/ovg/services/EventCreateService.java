/* Event Create Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Create an Event.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.repositories.EventRepository;

/** Implementation Create CRUD on Event */
@Component
@Transactional
public class EventCreateService {

    private static final Logger log = LoggerFactory.getLogger(EventCreateService.class);

    /** Link to Event repository.*/
    @Autowired
    private EventRepository repository;

    /** Create Event function implementation.*/
    Event create(final Event event) {
        log.debug("Create employee");

        // TODO Put your code here - create (...) Upload photo.

        return this.repository.save(event);
    }

}
