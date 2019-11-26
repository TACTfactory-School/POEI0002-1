/* Interface Fixtures DB Service.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.services;

import javax.transaction.Transactional;

public interface Fixture {
    @Transactional
    void load();
}
