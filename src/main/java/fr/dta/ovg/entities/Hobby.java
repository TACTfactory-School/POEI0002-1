/* Entity Hobby class.
 * @author Colin Cerveaux @C-ambium.
 * Define the entity Hobby.
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

import fr.dta.ovg.contracts.HobbyContract;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Entity Hobby class.*/
@Entity
@Table(name = HobbyContract.TABLE)
@ApiModel(value = HobbyContract.TABLE_API)
public class Hobby  extends EntityBase {

    @NotBlank
    @Column(name = HobbyContract.COL_LABEL, length = 100, nullable = true, unique = false)
    @ApiModelProperty(value = HobbyContract.COL_LABEL_API)
    private String label;

    @OneToMany(mappedBy = HobbyContract.MAPPED_BY_HOBBY)
    private final List<UserHobby> users = new ArrayList<>();

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

    /**
     * Get UserHobby.
     * @return users : UserHobby list.
     */
    public List<UserHobby> getUsers() {
        return users;
    }

    /**
     * Add Hobby with association table.
     * @param userHobby : UserHobby.
     */
    public void addUserHobby(final UserHobby userHobby) {
        if (!this.users.contains(userHobby)) {
            this.users.add(userHobby);
            userHobby.setHobby(this);
        }
    }

    /**
     * Remove Hobby from association table.
     * @param userHobby : UserHobby.
     */
    public void removeUserHobby(final UserHobby userHobby) {
        if (this.users.contains(userHobby)) {
            this.users.remove(userHobby);
        }
    }
}
