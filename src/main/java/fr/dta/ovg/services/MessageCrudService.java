package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.Message;
import fr.dta.ovg.exceptions.NotFoundException;

public interface MessageCrudService {

    /**
     * Get all Message entity.<br>
     * Must be redefined in implemented class.<br>
     * @return List of all Messages.
     * */
    List<Message> getAll();

    /**
     * Get one Message entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return Message : entity.
     * */
    Message getOne(long id) throws NotFoundException;

    /**
     * Create one Message entity.<br>
     * Must be redefined in implemented class.<br>
     * @return Created Message : entity.
     * */
    Message create(Message message);

    /**
     * Delete one Message entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return void : nothing.
     * */
    void delete(long id) throws NotFoundException;
}
