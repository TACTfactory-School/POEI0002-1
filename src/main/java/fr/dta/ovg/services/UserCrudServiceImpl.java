/* User Crud Service Implementation.
 * @author Colin Cerveaux @C-ambium
 * Action get and update / Link to Create & Delete Service
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.UserRepository;

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
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User getOne(final long id) throws NotFoundException {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Transactional()
    @Override
    public User create(final User user) {
        return this.createService.create(user);
    }

    @Override
    public void delete(long id) throws NotFoundException {
        // TODO Auto-generated method stub
        this.deleteService.delete(id);
    }

    @Override
//    @Query("SELECT COUNT(e) > 0"
//            + " FROM Event e"
//            + " WHERE LOWER(e.label) = LOWER(:#{#s.label})"
//            + " AND (:#{#s.id} = NULL OR e.id != :#{#s.id})")
    public boolean existsByLabel(User user) {
        // TODO Auto-generated method stub
        return this.repository.existsByLabel(user);
    }

    @Override
    public boolean existsByLabelIgnoreCaseAndIdNot(String label, Long id) {
        // TODO Auto-generated method stub
        return false;
    }

}
