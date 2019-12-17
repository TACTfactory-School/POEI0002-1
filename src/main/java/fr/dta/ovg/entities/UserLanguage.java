/* User Language class. Association table.
 * @author Colin Cerveaux @C-ambium.
 * Define Association table between User and Language.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/** User Language class. Association table.*/
@Entity
@Table(name = "app_us_lang_lvl")
public class UserLanguage extends EntityBase {

    /** Language Level of user. <br> DB Column. */
    @Column(name = "us_lang_lvl", unique = false, nullable = true)
    @ApiModelProperty(value = "The language level of the user.")
    @Enumerated(EnumType.ORDINAL)
    LanguageLevel level;

    /** Selected user. */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;

    /** Selected language. */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Language language;

    /** Get the language's user.
     * @return the user : @see User.*/
    public User getUser() {
        return user;
    }

    /** Set the language's user.
     * @param user the user to set.*/
    public void setUser(final User user) {
        if (this.user != user) {
            this.user = user;
            if (user != null) {
                user.addUserLanguage(this);
            }
        }
    }

    /** Get the user's language.
     * @return the language : @see Language.*/
    public Language getLanguage() {
        return language;
    }

    /** Set the user's language.
     * @param language the language to set.*/
    public void setLanguage(final Language language) {
        if (this.language != language) {
            this.language = language;
            if (language != null) {
                language.addLanguage(this);
            }
        }
    }

    /** Get the Language Level (Enumeration).
     * @return the level : @see LanguageLevel.*/
    public LanguageLevel getLevel() {
        return level;
    }

    /** Get the Language Level.
     * @param level the level to set.*/
    public void setLevel(final LanguageLevel level) {
        this.level = level;
    }
}
