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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "app_hobbies")
@ApiModel(value = "Describes a Hobby for our system.")
public class Hobby  extends EntityBase {

    @NotBlank
    @Column(name = "lang_label", length = 100, nullable = true, unique = false)
    @ApiModelProperty(value = "The language to create.")
    private String label;

    @OneToMany(mappedBy = "hobby")
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
     * @return the users
     */
    public List<UserHobby> getUsers() {
        return users;
    }

    public void addUserHobby(final UserHobby userHobby) {
        if (!this.users.contains(userHobby)) {
            this.users.add(userHobby);
            userHobby.setHobby(this);
        }
    }
    public void removeUserHobby(final UserHobby userHobby) {
        if (this.users.contains(userHobby)) {
            this.users.remove(userHobby);
        }
    }

}
