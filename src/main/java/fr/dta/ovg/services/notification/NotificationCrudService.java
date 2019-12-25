/* Interface Notification Crud Service.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */

package fr.dta.ovg.services.notification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.dta.ovg.entities.Notification;
import fr.dta.ovg.exceptions.NotFoundException;

/** Interface Notification CRUD Service.*/
public interface NotificationCrudService {

    /**
     * Get all Notification entity.<br>
     * Must be redefined in implemented class.<br>
     * @param pageable : @see Pageable.
     * @param userId : User Id notification.
     * @return List of all Notifications.
     * */
    Page<Notification> getAll(Pageable pageable, Long userId);

    /**
     * Get one Notification entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id : Notification id.
     * @return Notification : entity.
     * @throws NotFoundException : Setting not found.*/
    Notification getOne(long id) throws NotFoundException;

    /**
     * Create one Notification entity.<br>
     * Must be redefined in implemented class.<br>
     * @param notification : @see Notification.
     * @return Created Notification : entity.
     * */
    Notification create(Notification notification);

    /**
     * Delete one Notification entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id : Notification id.
     * @throws NotFoundException : Setting not found.*/
    void delete(long id) throws NotFoundException;
}
