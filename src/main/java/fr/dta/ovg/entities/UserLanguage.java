package fr.dta.ovg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "app_us_lang_lvl")
public class UserLanguage extends EntityBase{

    /** Language Level of user. <br> DB Column. */
    @Column(name = "us_lang_lvl", unique = false, nullable = true)
    @ApiModelProperty(value = "The language level of the user.")
    LanguageLevel level;

    /** Selected user. */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;

    /** Selected language. */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Language language;

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        if (this.user != user) {
            this.user = user;
            if (user != null) {
                user.addUserLanguage(this);
            }
        }
    }

    /**
     * @return the language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(Language language) {
        if (this.language != language) {
            this.language = language;
            if (language != null) {
                language.addLanguage(this);
            }
        }
    }

    /**
     * @return the level
     */
    public LanguageLevel getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(LanguageLevel level) {
        this.level = level;
    }
}
