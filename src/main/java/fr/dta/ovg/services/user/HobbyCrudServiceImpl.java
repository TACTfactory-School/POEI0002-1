/* Hobby CRUD Service Implementation.
 * @author Colin Cerveaux @C-ambium
 * Action get and update / Link to Delete Service
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.ovg.entities.Hobby;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.HobbyRepository;
import fr.dta.ovg.services.HobbyCrudService;

/** Hobby CRUD Service Implementation.*/
@Service
public class HobbyCrudServiceImpl implements HobbyCrudService {

    /** Link to entity repository.*/
    @Autowired
    private HobbyRepository repository;

    /** Logger instance. */
    private static final Logger LOG = LoggerFactory.getLogger(UserDeleteService.class);

    /** {@inheritDoc}.*/
    @Override
    public List<Hobby> getAll() {

        LOG.debug("Get All Hobbies");
        return this.repository.findAll();
    }

    /** {@inheritDoc}.*/
    @Override
    public Hobby getOne(final long id) throws NotFoundException {

        LOG.debug("Get one Hobby");
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    /** {@inheritDoc}.*/
    @Override
    public Hobby create(final Hobby hobby) {

        LOG.debug("Create Hobby");
        return this.repository.save(hobby);
    }

    /** {@inheritDoc}.*/
    @Override
    public void delete(final long id) throws NotFoundException {
        LOG.debug("Delete one Hobby by ID");

        Hobby hobby = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(hobby);
    }

    /** {@inheritDoc}.*/
    @Override
    public boolean existsByLabel(final Hobby hobby) {

        return this.repository.existsByLabel(hobby);
    }
}
