/* Entity base class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean enabled = false;

    protected EntityBase() {
        super();
    }

    /**
     * Getter id
     * @return the id (long).
     */
    public Long getId() {
        return id;
    }

    /**
     * Getter Function isEnabled.
     * @return boolean : enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Setter setEnabled.
     * @param boolean enabled : the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
