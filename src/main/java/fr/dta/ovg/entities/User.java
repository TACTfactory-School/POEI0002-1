/* Entity User class.
 * @author Colin Cerveaux @C-ambium
 * Define the entity User
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "app_users")
@ApiModel(value = "Describes an User for our system")
public class User extends EntityBase {


    private String role;

    /** Username of user. <br> DB Column. */
    @NotBlank
    @Column(name = "us_username", length = 32, nullable = false, unique = true)
    @ApiModelProperty(value = "The username of the user.")
    private String username;

    /** Email of user. <br> DB Column. */
    @NotBlank
    @Column(name = "us_email", length = 50, nullable = false, unique = true)
    @ApiModelProperty(value = "The email of the user.")
    private String email;

    /** Password of user. <br> DB Column. */
    @NotBlank
    @Column(name = "us_password", length = 32, unique = false, nullable = true)
    @ApiModelProperty(value = "The password of the user.")
    private String password; // TODO must be encrypted.

    /** Birthdate of user. <br> DB Column. */
    @Column(name = "us_birthdate", unique = false, nullable = false)
    @ApiModelProperty(value = "The birthdate of the user.")
    private LocalDate birthdate;

    /** Firstname of user. <br> DB Column. */
    @Column(name = "us_firstname", unique = false, nullable = true)
    @ApiModelProperty(value = "The firstname of the user.")
    private String firstname;

    /** City of user. <br> DB Column. */
    @Column(name = "us_city", unique = false, nullable = true)
    @ApiModelProperty(value = "The city of the user.")
    private String city;

    /** Job of user. <br> DB Column. */
    @Column(name = "us_job", unique = false, nullable = true)
    @ApiModelProperty(value = "The job of the user.")
    private String job;

    /** Fiability rate of user. <br> DB Column. */
    @Column(name = "us_rate", unique = false, nullable = true)
    @ApiModelProperty(value = "The fiability rate of the user.")
    private float rate;

    /** Last Login Date of user. <br> DB Column. */
    @Column(name = "us_lastlog", unique = false, nullable = true)
    @ApiModelProperty(value = "The last login date rate of the user.")
    private ZonedDateTime lastLogin;

    /** Gender of user. <br> DB Column. */
    @Column(name = "us_gender", unique = false, nullable = true)
    @ApiModelProperty(value = "The gender of the user.")
    private UserGender gender;

    /** Marital status of user. <br> DB Column. */
    @Column(name = "us_status", unique = false, nullable = true)
    @ApiModelProperty(value = "The marital status of the user.")
    private UserStatus maritalStatus;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private final List<JoinEvent> events = new ArrayList<>();

    /** Override toString() method with User attributes. */
    @Override
    public String toString() {
        return String.format("Username : %s | Email : %s | Birthdate : %dt",
                username, email, birthdate);
    }

    /**
     * @return the gender
     */
    public UserGender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(final UserGender gender) {
        this.gender = gender;
    }

    /**
     * @return the maritalStatus
     */
    public UserStatus getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(final UserStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(final String job) {
        this.job = job;
    }

    /**
     * @return the rate
     */
    public float getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(final float rate) {
        this.rate = rate;
    }

    /**
     * @return the lastLogin
     */
    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin the lastLogin to set
     */
    public void setLastLogin(final ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * @return the events
     */
    public List<JoinEvent> getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(final List<JoinEvent> events) {
        this.events.clear();
        this.events.addAll(events);
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
