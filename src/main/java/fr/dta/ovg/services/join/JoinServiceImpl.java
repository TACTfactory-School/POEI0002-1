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

import fr.dta.ovg.entities.Join;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.JoinRepository;
import fr.dta.ovg.services.JoinCrudService;

@Transactional
@Service
public class JoinServiceImpl implements JoinCrudService {

    /** Link to Join repository. */
    @Autowired
    private JoinRepository repository;

    /** Link to Delete Service. */
    @Autowired
    private JoinDeleteService service;

    /** Get All join from join repository. */
    @Transactional(readOnly = true)
    @Override
    public List<Join> getAll() {
        return this.repository.findAll();
    }

    /** Delete one join from join repository. */
    @Override
    public void delete(final long id) throws NotFoundException {
        this.service.delete(id);
    }

    /** Create one join from join repository. */
    @Transactional()
    @Override
    public Join create(final Join entity) {
        return this.repository.save(entity);
    }

    /** Get one join from join repository. */
    @Override
    public Join getOne(long id) throws NotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
}
