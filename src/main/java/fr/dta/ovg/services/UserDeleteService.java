/* User Delete Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Delete an Event.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.UserRepository;

@Component
@Transactional
public class UserDeleteService {

    private static final Logger log = LoggerFactory.getLogger(UserDeleteService.class);

    /** Link to User Repository */
    @Autowired
    private UserRepository repository;

    /** Delete User function implementation.*/
    void delete(final long id)  throws NotFoundException {
        log.debug("Delete User");

        // TODO Put your code here - delete (...) Save Stats.

        User user = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        this.repository.delete(user);
    }
}
