/* Language CRUD Service Implementation Class.
 * @author Colin Cerveaux @C-ambium
 * Implementation of crud service.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import java.util.List;

import fr.dta.ovg.entities.Language;
import fr.dta.ovg.exceptions.NotFoundException;

/** Language CRUD Service Interface.*/
public interface LanguageCrudService {

    /** Get all Language entity.<br>
     * Must be redefined in implemented class.<br>
     * @return List of all Languages.*/
    List<Language> getAll();

    /** Get one Language entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id : language id.
     * @return Language : entity.
     * @throws NotFoundException : Language not found.*/
    Language getOne(long id) throws NotFoundException;

    /** Create one Language entity.<br>
     * Must be redefined in implemented class.<br>
     * @param language : @see Language.
     * @return Created Language : entity.*/
    Language create(Language language);

    /** Delete one Language entity by ID.<br>
     * Must be redefined in implemented class.<br>
     * @param id : Language id to process delete.
     * @throws NotFoundException : Language not found.*/
    void delete(long id) throws NotFoundException;

    /** Exists by label function.
     * @param language : @see Language.
     * @return true if the language label already existing in the repository.*/
    boolean existsByLabel(Language language);

}
