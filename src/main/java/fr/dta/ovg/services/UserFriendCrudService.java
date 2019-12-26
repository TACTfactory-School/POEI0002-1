/* Interface UserFriend Crud Service.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */

package fr.dta.ovg.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.dta.ovg.entities.UserFriend;
import fr.dta.ovg.exceptions.NotFoundException;

/** UserFriend CRUD Service Interface.*/
public interface UserFriendCrudService {

    /** Get all UserFriend entity.<br>
     * Must be redefined in implemented class.<br>
     * @param pageable : @see Pageable.
     * @return List of all UserFriend.*/
    Page<UserFriend> getAll(Pageable pageable);

    /** Get one UserFriend entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id : UserFriend id.
     * @return UserFriend : entity.
     * @throws NotFoundException : User not found.*/
    UserFriend getOne(long id) throws NotFoundException;

    /** Create one UserFriend entity.<br>
     * Must be redefined in implemented class.<br>
     * @param userFriend : @see UserFriend.
     * @return Created UserFriend : entity.*/
    UserFriend create(UserFriend userFriend);

    /** Delete one UserFriend entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id : UserFriend id.
     * @throws NotFoundException : User not found.*/
    void delete(long id) throws NotFoundException;


    /** existsByUsernameIgnoreCaseAndIdNot.
     * @param username of the user.
     * @param id of the user.
     * @return true if user existing by username and id not.*/
    boolean existsByUsernameIgnoreCaseAndIdNot(String username, Long friendRequestId);
}

