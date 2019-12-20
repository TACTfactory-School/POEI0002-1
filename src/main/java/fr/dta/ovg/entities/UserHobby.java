/* User Hobby class. Association table.
 * @author Colin Cerveaux @C-ambium.
 * Define Association table between User and Hobby.
 * License : ©2019 All rights reserved.
 */

package fr.dta.ovg.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.dta.ovg.contracts.HobbyContract;

/** User Hobby class. Association table.*/
@Entity
@Table(name = HobbyContract.JOIN_TABLE)
public class UserHobby extends EntityBase {

    /** Selected user. */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;

    /** Selected Hobby. */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Hobby hobby;

    /** Get the hobby's user.
     * @return the user : @see User.*/
    public User getUser() {
        return user;
    }

    /** Set the hobby's user.
     * @param user the user to set.*/
    public void setUser(final User user) {
        if (this.user != user) {
            this.user = user;
            if (user != null) {
                user.addUserHobby(this);
            }
        }
    }

    /** Get the user's hobby.
     * @return the hobby : @see Hobby.*/
    public Hobby getHobby() {
        return hobby;
    }

    /** Set the user's hobby.
     * @param hobby the hobby to set.*/
    public void setHobby(final Hobby hobby) {
        if (this.hobby != hobby) {
            this.hobby = hobby;
            if (hobby != null) {
                user.addUserHobby(this);
            }
        }
    }
}
