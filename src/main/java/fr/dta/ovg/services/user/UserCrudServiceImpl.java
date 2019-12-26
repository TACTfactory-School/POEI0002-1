/* User Crud Service Implementation.
 * @author Colin Cerveaux @C-ambium
 * Action get and update / Link to Create & Delete Service
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.UserRepository;
import fr.dta.ovg.services.UserCrudService;

/** User CRUD Service Implementation Class.*/
@Service
public class UserCrudServiceImpl implements UserCrudService {

    /** Link to User Repo. */
    @Autowired
    private UserRepository repository;

    /** Link to Create Service.*/
    @Autowired
    private UserCreateService createService;

    /** Link to Delete Service. */
    @Autowired
    private UserDeleteService deleteService;

    /** {@inheritDoc}.*/
    @Transactional(readOnly = true)
    @Override
    public Page<User> getAll(final Pageable pageable, final String search) {
        final Page<User> paginateResult;

        if (search == null) {
            paginateResult = this.repository.findAll(pageable);
        } else {
              paginateResult = this.repository.findAll(search, pageable);
        }


        return paginateResult;
    }

    /** {@inheritDoc}.*/
    @Transactional(readOnly = true)
    @Override
    public User getOne(final long id) throws NotFoundException {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    /** {@inheritDoc}.*/
    @Transactional(readOnly = true)
    @Override
    public User getOne(final String username) throws NotFoundException {
        return this.repository
                .findByUsername(username)
                .orElseThrow(() -> new NotFoundException());
    }

    /** {@inheritDoc}.*/
    @Transactional()
    @Override
    public User create(final User user) {
        return this.createService.create(user);
    }

    /** {@inheritDoc}.*/
    @Override
    public void delete(final long id) throws NotFoundException {
        // TODO Auto-generated method stub
        this.deleteService.delete(id);
    }

    /** {@inheritDoc}.*/
    @Override
    public boolean existsByUsername(final User user) {

        return this.repository.existsByUsername(user);
    }

    /** {@inheritDoc}.*/
    @Override
    public boolean existsByUsernameIgnoreCaseAndIdNot(final String label, final Long id) {
        // TODO Auto-generated method stub
        return false;
    }

}
