package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.Language;
import fr.dta.ovg.exceptions.NotFoundException;

/** Language CRUD Service Interface.*/
public interface LanguageCrudService {

    /**
     * Get all Language entity.<br>
     * Must be redefined in implemented class.<br>
     * @return List of all Languages.
     * */
    List<Language> getAll();

    /**
     * Get one Language entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return Language : entity.
     * */
    Language getOne(long id) throws NotFoundException;

    /**
     * Create one Language entity.<br>
     * Must be redefined in implemented class.<br>
     * @return Created Language : entity.
     * */
    Language create(Language language);

    /**
     * Delete one Language entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @return void : nothing.
     * */
    void delete(long id) throws NotFoundException;

    /** Exists by label function.
     * @param language : @see Language.
     * @return true if the language label already existing in the repository.*/
    boolean existsByLabel(Language language);
}
