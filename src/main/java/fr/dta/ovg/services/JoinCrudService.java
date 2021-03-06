/* JoinEvent Crud Service.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved.*/

package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.JoinEvent;
import fr.dta.ovg.exceptions.NotFoundException;

/** Join CRUD Service Interface.*/
public interface JoinCrudService {

    /** Get all JoinEvent entity.
     * @return List of all JoinEvent.*/
    List<JoinEvent> getAll();

    /** Deletes the {@link JoinEvent} for given.
     * @param id : the id of the {@link JoinEvent} to delete.
     * @throws NotFoundException : Throws if {@link JoinEvent} entity not found.*/
    void delete(long id) throws NotFoundException;

    /** Get one JoinEvent entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id : JoinEvent id.
     * @return JoinEvent : entity.
     * @see fr.dta.ovg.services.join.JoinServiceImpl
     * @throws NotFoundException : Throws if one requested entity not found.*/
    JoinEvent getOne(long id) throws NotFoundException;

    /** Saves in database the given JoinEvent.
     * @param entity : The built entity.
     * @return The entity after hydratation.*/
    JoinEvent create(JoinEvent entity);

    /** Get one joinEvent by event ID and user ID.<br>
     * Must be redefined in implemented class.<br>
     * @param eventId : the ID of the event we're looking for.
     * @param userId : the ID of the user we're looking for.
     * @return a JoinEvent.*/
    JoinEvent getOneByEventAndUser(long eventId, long userId);
}
