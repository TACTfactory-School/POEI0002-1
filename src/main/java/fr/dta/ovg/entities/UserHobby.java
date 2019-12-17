package fr.dta.ovg.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "app_us_hobby")
public class UserHobby extends EntityBase {

    /** Selected user. */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;

    /** Selected Hobby. */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Hobby hobby;

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(final User user) {
        if (this.user != user) {
            this.user = user;
            if (user != null) {
                user.addUserHobby(this);
            }
        }
    }

    /**
     * @return the hobby
     */
    public Hobby getHobby() {
        return hobby;
    }

    /**
     * @param hobby the hobby to set
     */
    public void setHobby(final Hobby hobby) {
        if (this.hobby != hobby) {
            this.hobby = hobby;
            if (hobby != null) {
                user.addUserHobby(this);
            }
        }
    }
}
