/* Interface Notification Settings Crud Service.
 * @author Colin Cerveaux @C-ambium
 * Genericity of crud service.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.notification;

import java.util.List;

import fr.dta.ovg.entities.NotificationSetting;
import fr.dta.ovg.exceptions.NotFoundException;

/** Interface Notification Settings CRUD Service.*/
public interface NotificationSettingCrudService {
    /**
     * Get all Notification entity.<br>
     * Must be redefined in implemented class.<br>
     * @return List of all Notifications.
     * */
    List<NotificationSetting> getAll();

    /**
     * Get one Notification entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return Notification : entity.
     * */
    NotificationSetting getOne(long id) throws NotFoundException;

    /**
     * Create one Notification entity.<br>
     * Must be redefined in implemented class.<br>
     * @return Created Notification : entity.
     * */
    NotificationSetting create(NotificationSetting notificationSetting);

    /**
     * Delete one Notification entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return void : nothing.
     * */
    void delete(long id) throws NotFoundException;
}
