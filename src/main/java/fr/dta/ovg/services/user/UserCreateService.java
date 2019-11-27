/* User Create Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Create an Event.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.ovg.entities.User;
import fr.dta.ovg.repositories.UserRepository;

/** Implementation Create CRUD on User */
@Component
@Transactional
public class UserCreateService {

    private static final Logger log = LoggerFactory.getLogger(UserCreateService.class);

    /** Link to User repository. */
    @Autowired
    private UserRepository repository;

    /** Create User function implementation. */
    User create(final User user) {
        log.debug("Create User");

        // TODO Put your code here - create (...) Upload photo.

        return this.repository.save(user);
    }

}
