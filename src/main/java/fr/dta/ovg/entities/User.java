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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import fr.dta.ovg.contracts.JsonIgnoreContract;
import fr.dta.ovg.contracts.UserContract;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Entity User class.*/
@Entity
@Table(name = UserContract.TABLE)
@ApiModel(value = UserContract.TABLE_API)
public class User extends EntityBase {

    /** Username of user. <br> DB Column. */
    @NotBlank
    @Column(name = UserContract.COL_USERNAME, length = 32, nullable = false, unique = true)
    @ApiModelProperty(value = UserContract.COL_USERNAME_API)
    private String username;

    /** Email of user. <br> DB Column. */
    @NotBlank
    @Column(name = UserContract.COL_EMAIL, length = 50, nullable = false, unique = true)
    @ApiModelProperty(value = UserContract.COL_EMAIL_API)
    private String email;

    /** Password of user. <br> DB Column. */
    @NotBlank
    @Column(name = UserContract.COL_PASSWORD, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_PASSWORD_API)
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password; // TODO must be encrypted.

    /** Birthdate of user. <br> DB Column. */
    @Column(name = UserContract.COL_BIRTHDATE, unique = false, nullable = false)
    @ApiModelProperty(value = UserContract.COL_BIRTHDATE_API)
    private LocalDate birthdate;

    /** Firstname of user. <br> DB Column. */
    @Column(name = UserContract.COL_FIRSTNAME, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_FIRSTNAME_API)
    private String firstname;

    /** City of user. <br> DB Column. */
    @Column(name = UserContract.COL_CITY, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_CITY_API)
    private String city;

    /** Job of user. <br> DB Column. */
    @Column(name = UserContract.COL_JOB, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_JOB_API)
    private String job;

    /** Fiability rate of user. <br> DB Column. */
    @Column(name = UserContract.COL_RATE, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_RATE_API)
    private float rate;

    /** Last Login Date of user. <br> DB Column. */
    @Column(name = UserContract.COL_LAST_LOGIN, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_LAST_LOGIN_API)
    private LocalDateTime lastLogin;

    /** Gender of user. <br> DB Column. */
    @Column(name = UserContract.COL_GENDER, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_GENDER_API)
    @Enumerated(EnumType.ORDINAL)
    private UserGender gender;

    /** Marital status of user. <br> DB Column. */
    @Column(name = UserContract.COL_STATUS, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_STATUS_API)
    @Enumerated(EnumType.ORDINAL)
    private UserStatus maritalStatus;

    /** User Avatar. <br> DB Column. */
    @Column(name = UserContract.COL_AVATAR, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_AVATAR_API)
    private byte avatar;

    /** Join event List of the Event. <br>DB Column.*/
    @OneToMany(mappedBy = UserContract.MAPPED_BY_USER)
    @JsonIgnoreProperties({JsonIgnoreContract.USER})
//    @JsonIgnore
    private final List<JoinEvent> joinEvents = new ArrayList<>();

    /** The notifications preference of the user.*/
    @OneToOne
    private NotificationSetting preferences;

    /** The notifications list of the user.*/
    @OneToMany(mappedBy = UserContract.MAPPED_BY_USER)
    @JsonIgnoreProperties(JsonIgnoreContract.USER)
    private final List<Notification> notifications = new ArrayList<>();

    /** The emitted messages list of the user.*/
    @OneToMany(mappedBy = UserContract.MAPPED_BY_USER_EMITTER)
    private final List<Message> messagesEmitted = new ArrayList<>();

    /** The received messages list of the user.*/
    @OneToMany(mappedBy = UserContract.MAPPED_BY_USER_RECEIVER)
    private final List<Message> messagesReceived = new ArrayList<>();

    /** The languages list of the user.*/
    @OneToMany(mappedBy = UserContract.MAPPED_BY_USER)
    @JsonIgnoreProperties(JsonIgnoreContract.USER)
    private final List<UserLanguage> languages = new ArrayList<>();

    /** The hobbies list of the user.*/
    @OneToMany(mappedBy = UserContract.MAPPED_BY_USER)
    @JsonIgnoreProperties(JsonIgnoreContract.USER)
    private final List<UserHobby> hobbies = new ArrayList<>();

    /** The requested friends list of the user.*/
    @OneToMany
    @JsonIgnoreProperties({JsonIgnoreContract.USER_FRIENDS_REQUEST, JsonIgnoreContract.USER_FRIENDS_ACCEPT})
    private final List<UserFriend> friendsRequest = new ArrayList<>();

    /** The accepted friends list of the user.*/
    @OneToMany
    @JsonIgnoreProperties({JsonIgnoreContract.USER_FRIENDS_REQUEST, JsonIgnoreContract.USER_FRIENDS_ACCEPT})
    private final List<UserFriend> friendsAccept = new ArrayList<>();

    /** Birthdate preference setting of the user.. <br> DB Column. */
    @Column(name = UserContract.COL_PREF_BIRTHDATE, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_PREF_BIRTHDATE_API)
    private boolean birthdateHidden = false;

    /** Mail preference setting of the user.. <br> DB Column. */
    @Column(name = UserContract.COL_PREF_MAIL, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_PREF_MAIL_API)
    private boolean mailHidden = false;

    /** Job preference setting of the user.. <br> DB Column. */
    @Column(name = UserContract.COL_PREF_JOB, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_PREF_JOB_API)
    private boolean jobHidden = false;

    /** Gender preference setting of the user.. <br> DB Column. */
    @Column(name = UserContract.COL_PREF_GENDER, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_PREF_GENDER_API)
    private boolean genderHidden = false;

    /** Marital status preference setting of the user.. <br> DB Column. */
    @Column(name = UserContract.COL_PREF_STATUS, unique = false, nullable = true)
    @ApiModelProperty(value = UserContract.COL_PREF_STATUS_API)
    private boolean statusHidden = false;

    /** Override toString() method with User attributes. */
    @Override
    public String toString() {

        return String.format(UserContract.TO_STRING,
                username, email, firstname, birthdate, job, city, rate);
    }

    /** Getter user's gender.
     * @return the gender (UserGender Enum).*/
    public UserGender getGender() {
        return gender;
    }

    /** Setter user's gender.
     * @param gender : the user gender to set.*/
    public void setGender(final UserGender gender) {
        this.gender = gender;
    }

    /** Getter user's status.
     * @return the maritalStatus (UserStatus Enum).*/
    public UserStatus getMaritalStatus() {
        return maritalStatus;
    }

    /** Setter user's status.
     * @param maritalStatus  (UserStatus Enum) : the maritalStatus to set.*/
    public void setMaritalStatus(final UserStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /** Getter firstname.
     * @return the firstname (String).*/
    public String getFirstname() {
        return firstname;
    }

    /** Setter firstname.
     * @param firstname (String) : the firstname to set.*/
    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    /** Get the user city.
     * @return the city (String).*/
    public String getCity() {
        return city;
    }

    /** Set the user city.
     * @param city (String) the city to set.*/
    public void setCity(final String city) {
        this.city = city;
    }

    /** Get the user job.
     * @return the job (String).*/
    public String getJob() {
        return job;
    }

    /** Set the user job.
     * @param job the job to set (String).*/
    public void setJob(final String job) {
        this.job = job;
    }

    /** Get the user rate.
     * @return the user rate (float).*/
    public float getRate() {
        return rate;
    }

    /** Set the user rate.
     * @param rate (float) : the rate to set*/
    public void setRate(final float rate) {
        this.rate = rate;
    }

    /** Get the user last login date time.
     * @return the lastLogin (LocalDateTime).*/
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    /** Set the user last login date time.
     * @param lastLogin (LocalDateTime) : the lastLogin to set*/
    public void setLastLogin(final LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    /** Get the username.
     * @return the username (String).*/
    public String getUsername() {
        return username;
    }

    /** Set the username.
     * @param username (String) : the username to set.*/
    public void setUsername(final String username) {
        this.username = username;
    }

    /** Get the user email.
     * @return the email (String).*/
    public String getEmail() {
        return email;
    }

    /** Set the user email.
     * @param email (String) : the email to set.*/
    public void setEmail(final String email) {
        this.email = email;
    }

    /** Get the user birthdate.
     * @return the birthdate (LocalDate).*/
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /** Set the user birthdate.
     * @param birthdate (LocalDate) : the birthdate to set.*/
    public void setBirthdate(final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /** Get the user password.
     * @return the password (String not encrypted).*/
    public String getPassword() {
        return password;
    }

    /** Set the user password.
     * @param password (String not encrypted) : the password to set.*/
    public void setPassword(final String password) {
        this.password = password;
    }

    /** Get Role.
     * @return role : user role.*/
    public String getRole() {
        return "USER";
    }

    /** Get user notifications preference.
     * @return the preferences : @see NotificationSetting */
    public NotificationSetting getPreferences() {
        return preferences;
    }

    /** Set user notifications preference.
     * @param preferences the preferences to set.*/
    public void setPreferences(final NotificationSetting preferences) {
        this.preferences = preferences;
    }

    /** Get User hide birthdate preference.
     * @return the birthdateHidden : boolean.*/
    public boolean isBirthdateHidden() {
        return birthdateHidden;
    }

    /** Set User hide birthdate preference.
     * @param birthdateHidden the birthdateHidden to set.*/
    public void setBirthdateHidden(final boolean birthdateHidden) {
        this.birthdateHidden = birthdateHidden;
    }

    /** Get User hide email preference.
     * @return the mailHidden : boolean.*/
    public boolean isMailHidden() {
        return mailHidden;
    }

    /** Set User hide email preference.
     * @param mailHidden the mailHidden to set.*/
    public void setMailHidden(final boolean mailHidden) {
        this.mailHidden = mailHidden;
    }

    /** Get User hide job preference.
     * @return the jobHidden : boolean.*/
    public boolean isJobHidden() {
        return jobHidden;
    }

    /** Set User hide job preference.
     * @param jobHidden the jobHidden to set.*/
    public void setJobHidden(final boolean jobHidden) {
        this.jobHidden = jobHidden;
    }

    /** Get User hide gender preference.
     * @return the genderHidden : boolean.*/
    public boolean isGenderHidden() {
        return genderHidden;
    }

    /** Set User hide gender preference.
     * @param genderHidden the genderHidden to set.*/
    public void setGenderHidden(final boolean genderHidden) {
        this.genderHidden = genderHidden;
    }

    /** Get User hide marital status preference.
     * @return the statusHidden : boolean.*/
    public boolean isStatusHidden() {
        return statusHidden;
    }

    /** Set User hide marital status preference.
     * @param statusHidden the statusHidden to set.*/
    public void setStatusHidden(final boolean statusHidden) {
        this.statusHidden = statusHidden;
    }

    /**Set User Avatar.
     * @return the avatar of the user.*/
    public byte getAvatar() {
        return avatar;
    }

    /** Get User Avatar.
     * @param avatar the user avatar to set*/
    public void setAvatar(final byte avatar) {
        this.avatar = avatar;
    }

    /** Get user notifications list.
     * @return the notifications : @see Notification.*/
    public List<Notification> getNotifications() {
        return notifications;
    }

    /** Get user emitted messages list.
     * @return messagesEmitted : @see Message.*/
    public List<Message> getMessagesEmitted() {
        return messagesEmitted;
    }

    /** Get user received messages list.
     * @return the messagesReceived : @see Message.*/
    public List<Message> getMessagesReceived() {
        return messagesReceived;
    }

    /** Get user languages list.
     * @return the languages : @see UserLanguage.*/
    public List<UserLanguage> getLanguages() {
        return languages;
    }

    /** Get user hobbies list.
     * @return the hobbies : @see UserHobby.*/
    public List<UserHobby> getHobbies() {
        return hobbies;
    }

    /** Get List of all user's join events.
     * @return the events (List).*/
    public List<JoinEvent> getJoinEvents() {
        return joinEvents;
    }

    /** Get List of all user's friends request.
     * @return the friendsRequest.*/
    public List<UserFriend> getFriendsRequest() {
        return friendsRequest;
    }

    /** Get List of all user's friends accept.
     * @return the friendsAccept.*/
    public List<UserFriend> getFriendsAccept() {
        return friendsAccept;
    }

    /** @param userFriend : Add Friend to user. @see UserFriend.*/
    public void addFriendAccept(final UserFriend userFriend) {
        if (!this.friendsAccept.contains(userFriend)) {
            this.friendsAccept.add(userFriend);
            userFriend.setFriendAccept(this);
        }
    }

    /** @param userFriend : Add Friend to user. @see UserFriend.*/
    public void addFriendRequest(final UserFriend userFriend) {
        if (!this.friendsRequest.contains(userFriend)) {
            this.friendsRequest.add(userFriend);
            userFriend.setFriendRequest(this);
        }
    }

    /** @param joinEvent : Add join event to user */
    public void addJoinEvent(final JoinEvent joinEvent) {
        if (!this.joinEvents.contains(joinEvent)) {
            this.joinEvents.add(joinEvent);
            joinEvent.setUser(this);
        }
    }

    /** @param userLanguage : association table. Add language to user */
    public void addUserLanguage(final UserLanguage userLanguage) {
        if (!this.languages.contains(userLanguage)) {
            this.languages.add(userLanguage);
            userLanguage.setUser(this);
        }
    }

    /** @param userHobby : association table. Add hobby to user */
    public void addUserHobby(final UserHobby userHobby) {
        if (!this.hobbies.contains(userHobby)) {
            this.hobbies.add(userHobby);
            userHobby.setUser(this);
        }
    }

    /** @param userNotification : Add notification to user */
    public void addUserNotification(final Notification userNotification) {
        if (!this.notifications.contains(userNotification)) {
            this.notifications.add(userNotification);
            userNotification.setUser(this);
        }
    }

    /** @param messagesReceived : Add received message to user */
    public void addReceivedMessage(final Message messagesReceived) {
        if (!this.messagesReceived.contains(messagesReceived)) {
            this.messagesReceived.add(messagesReceived);
            messagesReceived.setUserReceiver(this);
        }
    }

    /** @param messagesEmitted : Add emitted message to user */
    public void addEmmittedMessage(final Message messagesEmitted) {
        if (!this.messagesEmitted.contains(messagesEmitted)) {
            this.messagesEmitted.add(messagesEmitted);
            messagesEmitted.setUserReceiver(this);
        }
    }

    /** @param joinEvent : Remove user join event.*/
    public void removeJoinEvent(final JoinEvent joinEvent) {
        if (this.joinEvents.contains(joinEvent)) {
            this.joinEvents.remove(joinEvent);
        }
    }
    /** @param userLanguage : Remove user language from association table.*/
    public void removeUserLanguage(final UserLanguage userLanguage) {
        if (this.languages.contains(userLanguage)) {
            this.languages.remove(userLanguage);
        }
    }

    /** @param userHobby : Remove user hobby from association table.*/
    public void removeUserHobby(final UserHobby userHobby) {
        if (this.hobbies.contains(userHobby)) {
            this.hobbies.remove(userHobby);
        }
    }

    /** @param userNotification : Remove user notification.*/
    public void removeUserNotification(final Notification userNotification) {
        if (this.notifications.contains(userNotification)) {
            this.notifications.remove(userNotification);
        }
    }

    /** @param messagesReceived : Remove user received message.*/
    public void removeReceivedMessage(final Message messagesReceived) {
        if (this.messagesReceived.contains(messagesReceived)) {
            this.messagesReceived.remove(messagesReceived);
        }
    }

    /** @param messagesEmitted : Remove user emitted message.*/
    public void removeEmmittedMessage(final Message messagesEmitted) {
        if (this.messagesEmitted.contains(messagesEmitted)) {
            this.messagesEmitted.remove(messagesEmitted);
        }
    }
}
