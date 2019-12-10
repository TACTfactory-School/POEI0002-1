/* Entity User class.
 * @author Colin Cerveaux @C-ambium
 * Define the entity User
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "app_users")
@ApiModel(value = "Describes an User for our system")
public class User extends EntityBase {


    private String role;

    /** Username of user <br> DB Column */
    @NotBlank
    @Column(length = 32, nullable = false, unique = true)
    @ApiModelProperty(value = "The username of the user")
    private String username;

    /** Email of user <br> DB Column */
    @NotBlank
    @Column(length = 50, nullable = false, unique = true)
    @ApiModelProperty(value = "The email of the user")
    private String email;

    /** Password of user <br> DB Column */
    @NotBlank
    @Column(length = 32, nullable = true)
    @ApiModelProperty(value = "The password of the user")
    private String password; // TODO must be encrypted.

    /** Birthdate of user <br> DB Column */
    @Column(nullable = false)
    @ApiModelProperty(value = "The birthdate of the user")
    private LocalDate birthdate;

    /** Registered date of user <br> DB Column */
//    @Column(nullable = false)
//    @JsonProperty(access = Access.READ_ONLY)
//    @CreatedDate
//    @ApiModelProperty(value = "The generated date of creation", readOnly = true)
//    private LocalDateTime registeredAt;
    @ManyToMany(mappedBy = "users")
    List<Event> events;

    /** Age of user */
//    @Transient
//    @ApiModelProperty(value = "The calculated age of the user", readOnly = true)
//    private byte age;
    // TODO : Calculate Age function -> move to mapper
    // LocalDate currentDate = LocalDate.now();
    // this.age = (byte) Period.between(birthdate, currentDate).getYears();

//    @PrePersist
//    public void init() {
//        this.registeredAt = LocalDateTime.now();
//    }

    /** Override toString() method with User attributes */
    @Override
    public String toString() {
        return String.format("Username : %s | Email : %s | Birthdate : %dt",
                username, email, birthdate);
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @return the birthdate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    public String getNoEncodedPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(final String role) {
        this.role = role;
    }

    /* Futures attributees
     *

    private String firstname;
    private String maritalStatus;
    private String job;
    private char sex;
    private String description;
    private String city;

    private String avatar;
    private float fiabilityRate;

    private Language[] languages;
    private Habbie[] hobbies;
    private User[] friendsList;
    private Event[] futureOutings
    private Event[] pastOutings
    private Event[] bestOutings

    */

}
