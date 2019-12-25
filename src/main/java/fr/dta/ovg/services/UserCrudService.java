/* Interface User Crud Service.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;

public interface UserCrudService {

    /**
     * Get all User entity.<br>
     * Must be redefined in implemented class.<br>
     * @return List of all User.
     * @see UserCrudServiceImpl UserCrudServiceImpl
     * */
    Page<User> getAll(Pageable pageable, String search);

    /**
     * Get one User entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return User : entity.
     * @see UserCrudServiceImpl UserCrudServiceImpl
     * */
    User getOne(long id) throws NotFoundException;

    User getOne(String username) throws NotFoundException;

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

    /** existsByUsernameIgnoreCaseAndIdNot function.
     * @param username of the user.
     * @param id of the user.
     * @return true if user existing by username and id not.*/
    boolean existsByUsernameIgnoreCaseAndIdNot(String username, Long id);

    /** existsByUsername function.
     * @param user : @see User entity.
     * @return true if the username exists.*/
    boolean existsByUsername(User user);

}
