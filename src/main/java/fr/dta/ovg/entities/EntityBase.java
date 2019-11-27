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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModelProperty;

@MappedSuperclass
public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = Access.READ_ONLY)
    @ApiModelProperty(value = "The generated database ID", readOnly = true)
    private Long id;

    @JsonProperty(access = Access.READ_ONLY)
    @ApiModelProperty(value = "Specifies if the entity if enabled or not", readOnly = true)
    private boolean enabled = true;

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
