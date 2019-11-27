/* Entity User class.
 * @author Colin Cerveaux @C-ambium
 * Define the entity User
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "app_users")
@ApiModel(value = "Describes an User for our system")
public class User extends EntityBase {


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
    @Column(nullable = false)
    @JsonProperty(access = Access.READ_ONLY)
    @CreatedDate
    @ApiModelProperty(value = "The generated date of creation", readOnly = true)
    private LocalDateTime registeredAt;

    /** Age of user */
    @Transient
    @ApiModelProperty(value = "The calculated age of the user", readOnly = true)
    private byte age;
    // TODO : Calculate Age function -> move to mapper
    // LocalDate currentDate = LocalDate.now();
    // this.age = (byte) Period.between(birthdate, currentDate).getYears();

    @PrePersist
    public void init() {
        this.registeredAt = LocalDateTime.now();
    }

    /** Override toString() method with User attributes */
    @Override
    public String toString() {
        return String.format("Registred at : %dt | Username : %s | Email : %s | Age : %d | Birthdate : %dt",
                registeredAt, username, email, age, birthdate);
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
    public void setUsername(String username) {
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
    public void setEmail(String email) {
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
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the age
     */
    public byte getAge() {
        return age;
    }

    /**
     * @return the registeredAt
     */
    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    /**
     * @param registeredAt the registeredAt to set
     */
    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
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
    public void setPassword(String password) {
        this.password = password;
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
