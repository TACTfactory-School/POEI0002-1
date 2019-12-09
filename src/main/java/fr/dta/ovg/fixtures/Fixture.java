/* Interface Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import javax.transaction.Transactional;

import fr.dta.ovg.exceptions.NotFoundException;

public interface Fixture {
    @Transactional
    void load() throws NotFoundException;
}
