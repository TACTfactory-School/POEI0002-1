/* JoinEvent Contract class.
 * Define all constants 4 clean code.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.contracts;

/** JOIN_EVENT CONTRACT - Constants Term.*/
public final class JoinEventContract {

    /** Private empty constructor of JoinEventContract.*/
    private JoinEventContract() {
        // nothing here.
    }

    // REPOSITORY SQL REQUESTS
    /**Find JoinEvent by Event ID and User ID.*/
    public static final String FIND_BY_USER_EVENT_ID = "SELECT * FROM app_join_event e "
                                                    + "WHERE e.event_id = ?1 "
                                                    + "AND e.user_id = ?2 "
                                                    + "LIMIT 1";

    // TABLE DEFINITION
    /** Table app_join_event. */
    public static final String TABLE = "app_join_event";
    /** Table app_hobbies API description. */
    public static final String TABLE_API = "Join table between user and event.";


    // COLUMNS DEFINITION
    /** Column us_ev_valid.*/
    public static final String COL_VALID = "us_ev_valid";
    /** Column us_ev_valid API Description.*/
    public static final String COL_VALID_API = "The hobby label to create.";

    /** Column us_ev_validatedAt.*/
    public static final String COL_VALIDATED_AT = "us_ev_validatedAt";
    /** Column us_ev_validatedAt API Description.*/
    public static final String COL_VALIDATED_AT_API = "Validation date of join event.";

    /** Column us_ev_role.*/
    public static final String COL_ROLE = "us_ev_role";
    /** Column us_ev_role API Description.*/
    public static final String COL_ROLE_API = "Describe the Role of the user in the Event.";

    // JSON IGNORE PROPERTIES.
    /** JSON ignore "joinEvents". */
    public static final String IGN_JOINEVENTS = "joinEvents";
    /** JSO

    /** Mapped by "hobby".*/
    public static final String MAPPED_BY_HOBBY = "hobby";

}
