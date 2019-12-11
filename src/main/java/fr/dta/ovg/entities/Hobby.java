/* Entity Hobby class.
 * @author Colin Cerveaux @C-ambium.
 * Define the entity Hobby.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "app_hobbies")
@ApiModel(value = "Describes a Hobby for our system.")
public class Hobby  extends EntityBase{

    private String label;

    /**
     * Getter label.
     * @return the label (String).
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter Label.
     * @param label the label to set (String).
     */
    public void setLabel(final String label) {
        this.label = label;
    }

}
