/* Interface Event Crud Service.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.exceptions.NotFoundException;

/** Event CRUD Service Interface.*/
public interface EventCrudService {

    /** Get all Event entity with pageable.<br>
     * Must be redefined in implemented class.<br>
     * @return List of all Event.
     * @param pageable (Pageable) object with page number and quantity.
     * @param search : string to process search.
     * @see EventCrudServiceImpl*/
    Page<Event> getAll(Pageable pageable, String search);

    /** Get one Event entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return Event : entity.
     * @param id of the Event.
     * @see EventCrudServiceImpl
     * @throws NotFoundException : Event not found.*/
    Event getOne(long id) throws NotFoundException;

    /** Create one Event entity.<br>
     * Must be redefined in implemented class.<br>
     * @return Created Event entity.
     * @param event : Event entity
     * @see EventCreateService*/
    Event create(Event event);

    /** Delete one Event entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id of the Event.
     * @throws NotFoundException : Event not found.
     * @see EventDeleteService EventDeleteService*/
    void delete(long id) throws NotFoundException;

}
