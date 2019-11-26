/* Interface User Crud Service.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;

public interface UserCrudService {

    /**
     * Get all User entity.<br>
     * Must be redefined in implemented class.<br>
     * @return List of all User.
     * @see UserCrudServiceImpl UserCrudServiceImpl
     * */
    List<User> getAll();

    /**
     * Get one User entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return User : entity.
     * @see UserCrudServiceImpl UserCrudServiceImpl
     * */
    User getOne(long id) throws NotFoundException;

    /**
     * Create one User entity.<br>
     * Must be redefined in implemented class.<br>
     * @return Created User : entity.
     * @see UserCreateService UserCreateService.
     * */
    User create(User user);

    /**
     * Delete one User entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return void : nothing.
     * @see UserDeleteService UserDeleteService.
     * */
    void delete(long id) throws NotFoundException;

    // TODO Delete this functions from event.

    boolean existsByLabelIgnoreCaseAndIdNot(String label, Long id);

    boolean existsByLabel(User user);
}
