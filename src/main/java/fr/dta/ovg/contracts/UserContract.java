/* User Contract class.
 * Define all constants 4 clean code.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.contracts;

/** USER CONTRACT - Constants Term.*/
public final class UserContract {

    /** Private empty constructor of UserContract.*/
    private UserContract() {
        // nothing here.
    }

    // TABLE DEFINITION
    /** Table app_users. */
    public static final String TABLE = "app_users";
    /** Table app_users API description. */
    public static final String TABLE_API = "Describes an User for our system.";

    // COLUMNS DEFINITION
    /** Column us_username. */
    public static final String COL_USERNAME = "us_username";
    /** Column us_username length. */
    public static final int COL_USERNAME_LENGTH = 32;
    /** Column us_username API Description. */
    public static final String COL_USERNAME_API = "The username of the user.";

    /** Column us_email. */
    public static final String COL_EMAIL = "us_email";
    /** Column us_email length. */
    public static final int COL_EMAIL_LENGTH = 50;
    /** Column us_email API Description. */
    public static final String COL_EMAIL_API = "The email of the user.";

    /** Column us_password. */
    public static final String COL_PASSWORD = "us_password";
    /** Column us_password API Description. */
    public static final String COL_PASSWORD_API = "The password of the user.";

    /** Column us_birthdate. */
    public static final String COL_BIRTHDATE = "us_birthdate";
    /** Column us_birthdate API Description. */
    public static final String COL_BIRTHDATE_API = "The birthdate of the user.";

    /** Column us_firstname. */
    public static final String COL_FIRSTNAME = "us_firstname";
    /** Column us_firstname API Description. */
    public static final String COL_FIRSTNAME_API = "The firstname of the user.";

    /** Column us_city. */
    public static final String COL_CITY = "us_city";
    /** Column us_city API Description. */
    public static final String COL_CITY_API = "The city of the user.";

    /** Column us_job. */
    public static final String COL_JOB = "us_job";
    /** Column us_job API Description. */
    public static final String COL_JOB_API = "The job of the user.";

    /** Column us_rate. */
    public static final String COL_RATE = "us_rate";
    /** Column us_rate API Description. */
    public static final String COL_RATE_API = "The fiability rate of the user.";

    /** Column us_lastlog. */
    public static final String COL_LAST_LOGIN = "us_lastlog";
    /** Column us_lastlog API Description. */
    public static final String COL_LAST_LOGIN_API = "The last login date rate of the user.";

    /** Column us_gender. */
    public static final String COL_GENDER = "us_gender";
    /** Column us_gender API Description. */
    public static final String COL_GENDER_API = "The gender of the user.";

    /** Column us_status. */
    public static final String COL_STATUS = "us_status";
    /** Column us_status API Description. */
    public static final String COL_STATUS_API = "The marital status of the user.";

    /** Column us_avatar. */
    public static final String COL_AVATAR = "us_avatar";
    /** Column us_avatar API Description. */
    public static final String COL_AVATAR_API = "The avatar of the user.";

    /** Column us_pref_birthdate. */
    public static final String COL_PREF_BIRTHDATE = "us_pref_birthdate";
    /** Column us_pref_birthdate API Description. */
    public static final String COL_PREF_BIRTHDATE_API = "Hidden birthdate preference setting of the user.";

    /** Column us_pref_mail. */
    public static final String COL_PREF_MAIL = "us_pref_mail";
    /** Column us_pref_mail API Description. */
    public static final String COL_PREF_MAIL_API = "Hidden email preference setting of the user.";

    /** Column us_pref_job. */
    public static final String COL_PREF_JOB = "us_pref_job";
    /** Column us_pref_job API Description. */
    public static final String COL_PREF_JOB_API = "Hidden job preference setting of the user.";

    /** Column us_pref_gender. */
    public static final String COL_PREF_GENDER = "us_pref_gender";
    /** Column us_pref_gender API Description. */
    public static final String COL_PREF_GENDER_API = "Hidden gender preference setting of the user.";

    /** Column us_pref_status. */
    public static final String COL_PREF_STATUS = "us_pref_status";
    /** Column us_pref_status API Description. */
    public static final String COL_PREF_STATUS_API = "Hidden marital status preference setting of the user.";

    /** Mapped by "user".*/
    public static final String MAPPED_BY_USER = "user";
    /** Mapped by "userEmitter".*/
    public static final String MAPPED_BY_USER_EMITTER = "userEmitter";
    /** Mapped by "userReceiver".*/
    public static final String MAPPED_BY_USER_RECEIVER = "userReceiver";

    /** Override to String function for app_users. */
    public static final String TO_STRING = "| Username : %s "
                                        + "| Email : %s "
                                        + "| Firstname : %s "
                                        + "| Birthdate : %dt "
                                        + "| Job : %s "
                                        + "| City : %s "
                                        + "| Rate : %d |";

}
