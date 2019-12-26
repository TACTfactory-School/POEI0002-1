/* Fixtures Checking Service.
 * @author Fabrice Reigner.
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */

package fr.dta.ovg.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.dta.ovg.exceptions.NotFoundException;

/** Fixtures Checking Service Class.*/
public abstract class FixtureCheck<R extends JpaRepository<?, ?>> implements Fixture {

    /** Link to Generic object/entity repository.*/
    @Autowired
    protected R repository;

    /** Override load function to check if data already loaded or existed.
     * @throws NotFoundException : entity not found.*/
    @Override
    public void load() throws NotFoundException {
        if (this.repository.count() == 0) {
            this.loadIfNoData();
        }
    }

    /** Load if no data function declaration.
     * @throws NotFoundException : entity not found.*/
    protected abstract void loadIfNoData() throws NotFoundException;
}
