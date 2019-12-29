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

/** User CRUD Service Interface.*/
public interface UserCrudService {

    /** Get all User entity (paginate).<br>
     * Must be redefined in implemented class.<br>
     * @param pageable : @see Pageable.
     * @param search : the string to process search.
     * @return List of all User.
     * @see fr.dta.ovg.services.user.UserCrudServiceImpl*/
    Page<User> getAll(Pageable pageable, String search);

    /** Get one User entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id : the user id to find.
     * @return User : entity.
     * @see fr.dta.ovg.services.user.UserCrudServiceImpl
     * @throws NotFoundException : User not found.*/
    User getOne(long id) throws NotFoundException;

    /** Get one user by Username function.
     * @param username : the user name.
     * @return the user with the username.
     * @throws NotFoundException : User entity not found.*/
    User getOne(String username) throws NotFoundException;

    /** Create one User entity.<br>
     * Must be redefined in implemented class.<br>
     * @return Created User : entity.
     * @param user : User entity.
     * @see fr.dta.ovg.services.user.UserCreateService*/
    User create(User user);

    /** Delete one User entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id : User id to process delete.
     * @throws NotFoundException : User not found.
     * @see fr.dta.ovg.services.user.UserDeleteService*/
    void delete(long id) throws NotFoundException;

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
