/* Interface Event Crud Service.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.Event;
import fr.dta.ovg.exceptions.NotFoundException;

public interface EventCrudService {

    /**
     * Get all Event entity.<br>
     * Must be redefined in implemented class.<br>
     * @return List of all Event.
     * @see EventCrudServiceImpl EventCrudServiceImpl
     * */
    List<Event> getAll();

    /**
     * Get one Event entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return Event : entity.
     * @see EventCrudServiceImpl EventCrudServiceImpl
     * */
    Event getOne(long id) throws NotFoundException;

    /**
     * Create one Event entity.<br>
     * Must be redefined in implemented class.<br>
     * @return Created Event : entity.
     * @see EventCreateService EventCreateService.
     * */
    Event create(Event event);

    /**
     * Delete one Event entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return void : nothing.
     * @see EventDeleteService EventDeleteService.
     * */
    void delete(long id) throws NotFoundException;

    // TODO Delete this functions and move it to User.
    boolean existsByLabel(Event event);

    boolean existsByLabelIgnoreCaseAndIdNot(String label, Long id);
}
