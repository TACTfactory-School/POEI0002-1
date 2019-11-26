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

    @Autowired
    private EventRepository repository;

    void delete(final long id)  throws NotFoundException {
        log.debug("Create employee");

        // Todo delete (...) Save Stats

        Event event = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(event);
    }
}
