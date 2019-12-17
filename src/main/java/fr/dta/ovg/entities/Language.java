/* Entity Language class.
 * @author Colin Cerveaux @C-ambium.
 * Define the entity Language.
 * License : ©2019 All rights reserved.
 */

package fr.dta.ovg.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/* Entity Language class.*/
@Entity
@Table(name = "app_languages")
@ApiModel(value = "Describes a Language for our system")
public class Language extends EntityBase {


    @NotBlank
    @Column(name = "lang_label", length = 500, nullable = true, unique = false)
    @ApiModelProperty(value = "The language to create.")
    private String label;


    @OneToMany(mappedBy = "language")
    private final List<UserLanguage> users = new ArrayList<>();

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

    /** Get UserLangage.
     * @return the users : UserLangage list.
     */
    public List<UserLanguage> getUsers() {
        return users;
    }

    /** Add Language.
     * @param userLanguage.*/
    public void addLanguage(final UserLanguage userLanguage) {
        if (!this.users.contains(userLanguage)) {
            this.users.add(userLanguage);
            userLanguage.setLanguage(this);
        }
    }

    /** Remove Language.
     * @param userLanguage : UserLangage.*/
    public void removeLanguage(final UserLanguage userLanguage) {
        if (this.users.contains(userLanguage)) {
            this.users.remove(userLanguage);
        }
    }
}
