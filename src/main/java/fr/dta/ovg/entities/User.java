/* Entity User class.
 * @author Colin Cerveaux @C-ambium
 * Define the entity User
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Column(name = "us_password", unique = false, nullable = true)
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
    private LocalDateTime lastLogin;

    /** Gender of user. <br> DB Column. */
    @Column(name = "us_gender", unique = false, nullable = true)
    @ApiModelProperty(value = "The gender of the user.")
    private UserGender gender;

    /** Marital status of user. <br> DB Column. */
    @Column(name = "us_status", unique = false, nullable = true)
    @ApiModelProperty(value = "The marital status of the user.")
    private UserStatus maritalStatus;

    /** Join event List of the Event. <br>DB Column.*/
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private final List<JoinEvent> events = new ArrayList<>();

    /** Override toString() method with User attributes. */
    @Override
    public String toString() {
        return String.format("Username : %s | Email : %s | Birthdate : %dt",
                username, email, birthdate);
    }

    /**
     * Getter user's gender.
     * @return the gender (UserGender Enum).
     */
    public UserGender getGender() {
        return gender;
    }

    /**
     * Setter user's gender.
     * @param type (UserGender Enum) : the gender to set.
     */
    public void setGender(final UserGender gender) {
        this.gender = gender;
    }

    /**
     * Getter user's status.
     * @return the maritalStatus (UserStatus Enum).
     */
    public UserStatus getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Setter user's status.
     * @param maritalStatus  (UserStatus Enum) : the maritalStatus to set.
     */
    public void setMaritalStatus(final UserStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * Getter firstname.
     * @return the firstname (String).
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Setter firstname.
     * @param firstname (String) : the firstname to set.
     */
    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    /**
     * Get the user city.
     * @return the city (String).
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the user city.
     * @param city (String) the city to set.
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * Get the user job.
     * @return the job (String).
     */
    public String getJob() {
        return job;
    }

    /**
     * Set the user job.
     * @param job the job to set (String)
     */
    public void setJob(final String job) {
        this.job = job;
    }

    /**
     * Get the user rate.
     * @return the user rate (float).
     */
    public float getRate() {
        return rate;
    }

    /**
     * Set the user rate.
     * @param rate (float) : the rate to set
     */
    public void setRate(final float rate) {
        this.rate = rate;
    }

    /**
     * Get the user last login date time.
     * @return the lastLogin (LocalDateTime).
     */
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    /**
     * Set the user last login date time.
     * @param lastLogin (LocalDateTime) : the lastLogin to set
     */
    public void setLastLogin(final LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * Get List of all user's join events.
     * @return the events (List).
     */
    public List<JoinEvent> getEvents() {
        return events;
    }

    /**
     * Set List of all user's join event.
     * @param events (List) : the events to set.
     */
    public void setEvents(final List<JoinEvent> events) {
        // TODO TO REMOVE
        this.events.clear();
        this.events.addAll(events);
    }

    /**
     * Get the username.
     * @return the username (String).
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username.
     * @param username (String) : the username to set.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Get the user email.
     * @return the email (String).
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user email.
     * @param email (String) : the email to set.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Get the user birthdate.
     * @return the birthdate (LocalDate).
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Set the user birthdate.
     * @param birthdate (LocalDate) : the birthdate to set.
     */
    public void setBirthdate(final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Get the user password.
     * @return the password (String not encrypted).
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user password.
     * @param password (String not encrypted) : the password to set.
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
        return "USER";
    }

//    @Override
//    public String getName() {
//        // TODO Auto-generated method stub
//        return this.getUsername();
//    }

    /* Futures attributees
    private Language[] languages;
    private Habbie[] hobbies;
    private User[] friendsList;
    private Event[] futureOutings
    private Event[] pastOutings
    private Event[] bestOutings
    */
}
