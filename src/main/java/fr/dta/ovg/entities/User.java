package fr.dta.ovg.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "app_users")
public class User extends EntityBase {


    /** Username of user <br> DB Column */
    @Column(length = 32, nullable = false, unique = true)
    @NotBlank
    private String username;

    /** Email of user <br> DB Column */
    @Column(length = 50, nullable = false, unique = true)
    @NotBlank
    private String email;

    /** Password of user <br> DB Column */
    @Column(length = 32, nullable = false)
    @NotBlank
    private String password; // TODO must be encrypted.

    /** Birthdate of user <br> DB Column */
    @Column(nullable = false)
    @NotBlank
    private LocalDate birthdate;

    /** Age of user <br> DB Column */
    @Column(nullable = false)
    @NotBlank
    private byte age;

    /** Registered date of user <br> DB Column */
    @Column(nullable = false, unique = true)
    @NotBlank
    private LocalDateTime registeredAt;

    @PrePersist
    public void init() {

        LocalDate currentDate = LocalDate.now();

        this.age = (byte) Period.between(birthdate, currentDate).getYears();
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
