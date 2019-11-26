/* Event Delete Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Delete an Event.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.EventRepository;

@Component
@Transactional
public class EventDeleteService {

    private static final Logger log = LoggerFactory.getLogger(EventCreateService.class);

    /** Link to Event Repository */
    @Autowired
    private EventRepository repository;

    /** Delete Event function implementation.*/
    void delete(final long id)  throws NotFoundException {
        log.debug("Create employee");

        // TODO Put your code here - delete (...) Save Stats.

        Event event = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(event);
    }
}
