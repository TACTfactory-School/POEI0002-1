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

import fr.dta.ovg.contracts.LanguageContract;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Entity Language class.*/
@Entity
@Table(name = LanguageContract.TABLE)
@ApiModel(value = LanguageContract.TABLE_API)
public class Language extends EntityBase {

    /** Label of the Language. <br>DB Column.*/
    @NotBlank
    @Column(name = LanguageContract.COL_LABEL, length = 500, nullable = true, unique = false)
    @ApiModelProperty(value = LanguageContract.COL_LABEL_API)
    private String label;

    /** Join Table UserLanguage. <br>DB Column.*/
    @OneToMany(mappedBy = LanguageContract.MAPPED_BY_LANGUAGE)
    private final List<UserLanguage> users = new ArrayList<>();

    /** Getter Language label.
     * @return the label (String).*/
    public String getLabel() {
        return label;
    }

    /** Setter Language label.
     * @param label the label to set (String).*/
    public void setLabel(final String label) {
        this.label = label;
    }

    /** Get UserLangage.
     * @return the users : UserLangage list.*/
    public List<UserLanguage> getUsers() {
        return users;
    }

    /** Add Language.
     * @param userLanguage : @see UserLanguage.*/
    public void addLanguage(final UserLanguage userLanguage) {
        if (!this.users.contains(userLanguage)) {
            this.users.add(userLanguage);
            userLanguage.setLanguage(this);
        }
    }

    /** Remove Language.
     * @param userLanguage : @see UserLangage.*/
    public void removeLanguage(final UserLanguage userLanguage) {
        if (this.users.contains(userLanguage)) {
            this.users.remove(userLanguage);
        }
    }
}
