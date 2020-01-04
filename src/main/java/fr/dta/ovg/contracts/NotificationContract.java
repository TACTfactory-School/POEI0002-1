/* Notification Contract class.
 * Define all constants 4 clean code.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.contracts;

/** NOTIFICATION CONTRACT - Constants Term.*/
public final class NotificationContract {

    /** Private empty constructor of NotificationContract.*/
    private NotificationContract() {
        // nothing here.
    }

    // REPOSITORY SQL REQUESTS
    /** Return all notifications by user ID.*/
    public static final String SEL_ALL_BY_USER_ID = "SELECT n FROM Notification n "
                                                    + "INNER JOIN n.user u "
                                                    + "WHERE u.id = :userId "
                                                    + "ORDER BY n.createdAt DESC";

    // TABLE DEFINITION
    /** Table app_notifications. */
    public static final String TABLE = "app_notifications";
    /** Table app_notifications API description. */
    public static final String TABLE_API = "Describes a Notification for our system.";

    // COLUMNS DEFINITION
    /** Column notif_label. */
    public static final String COL_LABEL = "notif_label";
    /** Column notif_label API Description. */
    public static final String COL_LABEL_API = "The notification to send.";
    /** Column notif_label length. */
    public static final int COL_LABEL_LENGTH = 255;

}
