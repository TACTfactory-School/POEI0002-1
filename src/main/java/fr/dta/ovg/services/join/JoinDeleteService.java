/* Join Delete Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Delete a Join.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.repositories.JoinRepository;

@Component
public class JoinDeleteService {

    /** Link to Join repository. */
    @Autowired
    private JoinRepository repository;

    public void delete(final long id) throws NotFoundException {
        this.repository.delete(
                this.repository
                    .findById(id)
                    .orElseThrow(() -> new NotFoundException()));
    }
}
