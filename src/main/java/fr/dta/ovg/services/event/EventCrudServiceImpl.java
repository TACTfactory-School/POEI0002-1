/* Event Crud Service Implementation.
 * @author Colin Cerveaux @C-ambium
 * Action get and update / Link to Create & Delete Service
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.event;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.EventRepository;
import fr.dta.ovg.services.EventCrudService;


@Service
public class EventCrudServiceImpl implements EventCrudService {

    /** Link to Event Repo. */
    @Autowired
    private EventRepository repository;

    /** Link to Create Service.*/
    @Autowired
    private EventCreateService createService;

    /** Link to Delete Service. */
    @Autowired
    private EventDeleteService deleteService;

    @Transactional(readOnly = true)
    @Override
    public List<Event> getAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Event getOne(final long id) throws NotFoundException {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Transactional()
    @Override
    public Event create(final Event event) {
        return this.createService.create(event);
    }

    @Override
    public void delete(final long id) throws NotFoundException {
        // TODO Auto-generated method stub
        this.deleteService.delete(id);
    }

}
