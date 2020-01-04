/* Message Contract class.
 * Define all constants 4 clean code.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.contracts;

/** MESSAGE CONTRACT - Constants Term.*/
public final class MessageContract {

    /** Private empty constructor of MessageContract.*/
    private MessageContract() {
        // nothing here.
    }

 // REPOSITORY SQL REQUESTS
    /** Return all messages by user ID.*/
    public static final String SEL_ALL_BY_USER_ID = "SELECT m FROM Message m "
                                                    + "INNER JOIN m.userReceiver u "
                                                    + "WHERE u.id = :userId "
                                                    + "ORDER BY m.createdAt DESC";

    // TABLE DEFINITION
    /** Table app_messages. */
    public static final String TABLE = "app_messages";
    /** Table app_messages API description. */
    public static final String TABLE_API = "Describes a Message for our system.";

    // COLUMNS DEFINITION
    /** Column mess_label. */
    public static final String COL_LABEL = "mess_label";
    /** Column mess_label API Description. */
    public static final String COL_LABEL_API = "The message to send.";
    /** Column mess_label length. */
    public static final int COL_LABEL_LENGTH = 500;
}
