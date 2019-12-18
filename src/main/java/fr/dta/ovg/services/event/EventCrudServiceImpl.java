/* Event Crud Service Implementation.
 * @author Colin Cerveaux @C-ambium
 * Action get and update / Link to Create & Delete Service
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.EventRepository;
import fr.dta.ovg.services.EventCrudService;

/** Implementation CRUD service on Event. */
@Service
public class EventCrudServiceImpl implements EventCrudService {

    /** Link to Event Repository. */
    @Autowired
    private EventRepository repository;

    /** Link to Create Service.*/
    @Autowired
    private EventCreateService createService;

    /** Link to Delete Service. */
    @Autowired
    private EventDeleteService deleteService;

    /** Get All function.<br>Return Page of event.
     * @param pageable : @see Pageable.
     * @param search : String to prpcess search.*/
    @Transactional(readOnly = true)
    @Override
    public Page<Event> getAll(final Pageable pageable, final String search) {

        // Sort sort = Sort.by(Direction.DESC, "startAt");
        Pageable pageableFinal = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<Event> paginateResult;

        if (search != null) {
            paginateResult = this.repository.findAll(search, pageableFinal);
        } else {
            paginateResult = this.repository.findAll(pageableFinal);
        }

        return paginateResult;
    }

    /** Get One by ID.
     * @param id : number of the selected event.
     * @return Entity Event.
     * @throws NotFoundException : Event entity not found.*/
    @Transactional(readOnly = true)
    @Override
    public Event getOne(final long id) throws NotFoundException {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    /**
     * Create an Event.<br>
     * @param event : Event entity.
     * @return the created object User.*/
    @Transactional()
    @Override
    public Event create(final Event event) {
        return this.createService.create(event);
    }

    /** Delete one by ID. <br>
     * @param id : number of the selected Event.
     * @throws NotFoundException : Event entity not found exception.
     */
    @Override
    public void delete(final long id) throws NotFoundException {

        this.deleteService.delete(id);
    }

}
