package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.Notification;
import fr.dta.ovg.exceptions.NotFoundException;

public interface NotificationCrudService {

    /**
     * Get all Notification entity.<br>
     * Must be redefined in implemented class.<br>
     * @return List of all Notifications.
     * */
    List<Notification> getAll();

    /**
     * Get one Notification entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return Notification : entity.
     * */
    Notification getOne(long id) throws NotFoundException;

    /**
     * Create one Notification entity.<br>
     * Must be redefined in implemented class.<br>
     * @return Created Notification : entity.
     * */
    Notification create(Notification notification);

    /**
     * Delete one Notification entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return void : nothing.
     * */
    void delete(long id) throws NotFoundException;
}
