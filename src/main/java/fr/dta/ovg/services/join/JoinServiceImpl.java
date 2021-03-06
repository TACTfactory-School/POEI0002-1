/* Join Crud Service Implementation.
 * @author Colin Cerveaux @C-ambium
 * Action get and update / Link to Delete Service
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.join;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.ovg.entities.JoinEvent;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.JoinEventRepository;
import fr.dta.ovg.services.JoinCrudService;

/** JoinEvent Service Implementation.*/
@Transactional
@Service
public class JoinServiceImpl implements JoinCrudService {

    /** Link to Join repository. */
    @Autowired
    private JoinEventRepository repository;

    /** Link to Delete Service. */
    @Autowired
    private JoinDeleteService service;

    /** Get All join from join repository. */
    @Transactional(readOnly = true)
    @Override
    public List<JoinEvent> getAll() {
        return this.repository.findAll();
    }

    /** Delete one join from join repository.
     * @param id : number of the selected Event.*/
    @Override
    public void delete(final long id) throws NotFoundException {
        this.service.delete(id);
    }

    /** Create one join from join repository.
     * @param entity : @see JoinEvent.*/
    @Transactional()
    @Override
    public JoinEvent create(final JoinEvent entity) {
        return this.repository.save(entity);
    }

    /** Get one joinEvent from repository.
     * @param id : number of the selected JoinEvent.*/
    @Override
    public JoinEvent getOne(final long id) throws NotFoundException {
        // TODO Auto-generated method stub
        return this.repository.getOne(id);
    }

    /** Get one joinEvent by event ID and user ID.
     * @param eventId : the ID of the event we're looking for.
     * @param userId : the ID of the user we're looking for.
     */
   @Override
   public JoinEvent getOneByEventAndUser(final long eventId, final long userId) {
       return this.repository.findAllByEventAndUser(eventId, userId);
   }
}
