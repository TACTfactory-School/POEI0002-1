/* Hobby CRUD Service Interface.
 * @author Colin Cerveaux @C-ambium
 * Action get and update / Link to Delete Service
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.Hobby;
import fr.dta.ovg.exceptions.NotFoundException;

/** Hobby CRUD Service Interface.*/
public interface HobbyCrudService {

    /** Get all Hobby entity.<br>
     * Must be redefined in implemented class.<br>
     * @return List of all Hobbies.*/
    List<Hobby> getAll();

    /**  Get one Hobby entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id of Hobby entity.
     * @return Hobby : entity.
     * @throws NotFoundException : Hobby not found.*/
    Hobby getOne(long id) throws NotFoundException;

    /** Create one Hobby entity.<br>
     * Must be redefined in implemented class.<br>
     * @param hobby : @see Hobby.
     * @return Created Hobby : entity.*/
    Hobby create(Hobby hobby);

    /** Delete one Hobby entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id of Hobby entity.
     * @throws NotFoundException : hobby not found.*/
    void delete(long id) throws NotFoundException;

    /** Exists by Label function.
     * @param hobby : @see Hobby.
     * @return true if entity exists by label.*/
    boolean existsByLabel(Hobby hobby);
}
