package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.Hobby;
import fr.dta.ovg.exceptions.NotFoundException;

public interface HobbyCrudService {

    /**
     * Get all Hobby entity.<br>
     * Must be redefined in implemented class.<br>
     * @return List of all Hobbies.
     * */
    List<Hobby> getAll();

    /**
     * Get one Hobby entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return Hobby : entity.
     * */
    Hobby getOne(long id) throws NotFoundException;

    /**
     * Create one Hobby entity.<br>
     * Must be redefined in implemented class.<br>
     * @return Created Hobby : entity.
     * */
    Hobby create(Hobby hobby);

    /**
     * Delete one Hobby entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return void : nothing.
     * */
    void delete(long id) throws NotFoundException;

    boolean existsByLabel(Hobby hobby);
}
