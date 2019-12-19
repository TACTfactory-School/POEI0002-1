/* User Crud Service Implementation.
 * @author Colin Cerveaux @C-ambium
 * Action get and update / Link to Create & Delete Service
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.UserRepository;
import fr.dta.ovg.services.UserCrudService;

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

    @Transactional(readOnly = true)
    @Override
    public User getOne(final long id) throws NotFoundException {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Transactional(readOnly = true)
    @Override
    public User getOne(final String username) throws NotFoundException {
        return this.repository
                .findByUsername(username)
                .orElseThrow(() -> new NotFoundException());
    }

    @Transactional()
    @Override
    public User create(final User user) {
        return this.createService.create(user);
    }

    @Override
    public void delete(final long id) throws NotFoundException {
        // TODO Auto-generated method stub
        this.deleteService.delete(id);
    }

    /* (non-Javadoc)
     * @see fr.dta.ovg.services.UserCrudService#existsByUsername(fr.dta.ovg.entities.User)
     */
    @Override
    public boolean existsByUsername(final User user) {
//      TODO @Query("SELECT COUNT(e) > 0"
//      + " FROM Event e"
//      + " WHERE LOWER(e.label) = LOWER(:#{#s.label})"
//      + " AND (:#{#s.id} = NULL OR e.id != :#{#s.id})")
        return this.repository.existsByUsername(user);
    }

    /* (non-Javadoc)
     * @see fr.dta.ovg.services.UserCrudService#existsByUsernameIgnoreCaseAndIdNot(java.lang.String, java.lang.Long)
     */
    @Override
    public boolean existsByUsernameIgnoreCaseAndIdNot(final String label, final Long id) {
        // TODO Auto-generated method stub
        return false;
    }

}
