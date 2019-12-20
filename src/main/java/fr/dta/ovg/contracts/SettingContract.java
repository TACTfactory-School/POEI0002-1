/* Notification Settings Contract class.
 * Define all constants 4 clean code.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.contracts;

/** NOTIFICATIONS SETTINGS CONTRACT - Constants Term.*/
public final class SettingContract {

    /** Private empty constructor of SettingContract.*/
    private SettingContract() {
        // nothing here.
    }

    // TABLE DEFINITION
    /** Table app_settings. */
    public static final String TABLE = "app_settings";
    /** Table app_settings API description. */
    public static final String TABLE_API = "Describes Notification settings for our system.";


    // COLUMNS DEFINITION
    /** Column set_active_app.*/
    public static final String COL_ACTIVE_APP = "set_active_app";
    /** Column set_active_app API Description.*/
    public static final String COL_ACTIVE_APP_API = "Active application notifications.";

    /** Column set_active_mail.*/
    public static final String COL_ACTIVE_MAIL = "set_active_mail";
    /** Column set_active_mail API Description.*/
    public static final String COL_ACTIVE_MAIL_API = "Active mail notifications.";
}
