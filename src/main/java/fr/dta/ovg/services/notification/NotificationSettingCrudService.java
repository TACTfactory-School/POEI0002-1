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
     * @return List of all Notifications.*/
    List<NotificationSetting> getAll();

    /**
     * Get one Notification setting entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id of notification setting.
     * @return Notification : entity.
     * @throws NotFoundException : Setting not found.*/
    NotificationSetting getOne(long id) throws NotFoundException;

    /**
     * Create one Notification setting entity.<br>
     * Must be redefined in implemented class.<br>
     * @param notificationSetting : @see NotificationSetting entity.
     * @return Created Notification setting : entity.
     * */
    NotificationSetting create(NotificationSetting notificationSetting);

    /**
     * Delete one Notification setting entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id of notification setting entity.
     * @throws NotFoundException : Setting not found.*/
    void delete(long id) throws NotFoundException;

    /** Find one Notification settings by user ID.
     * @param userId : user id to process DB request.
     * @return NatificationSetting : boolean preferences MAILL and APP notifications.*/
    NotificationSetting getOneByUserId(long userId);
}
