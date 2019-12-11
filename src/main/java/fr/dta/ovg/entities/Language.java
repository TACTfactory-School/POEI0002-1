/* Entity Language class.
 * @author Colin Cerveaux @C-ambium.
 * Define the entity Language.
 * License : ©2019 All rights reserved.
 */

package fr.dta.ovg.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "app_languages")
@ApiModel(value = "Describes a Language for our system")
public class Language extends EntityBase {

    private String label;

    /**
     * Getter Language label.
     * @return the label (String).
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter Language label.
     * @param label the label to set (String).
     */
    public void setLabel(final String label) {
        this.label = label;
    }
}
