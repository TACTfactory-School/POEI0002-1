/* Hobby Contract class.
 * Define all constants 4 clean code.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.contracts;

/** HOBBY CONTRACT - Constants Term.*/
public final class HobbyContract {

    /** Private empty constructor of HobbyContract.*/
    private HobbyContract() {
        // nothing here.
    }

    // REPOSITORY SQL REQUESTS
    /** Request if hobby entity exists by label.*/
    public static final String EXISTS_BY_LABEL = "SELECT COUNT(h) > 0"
                                                + " FROM Hobby h"
                                                + " WHERE LOWER(h.label) = LOWER(:#{#s.label})"
                                                + " AND (:#{#s.id} = NULL OR h.id != :#{#s.id})";
    // TABLE DEFINITION
    /** Table app_hobbies. */
    public static final String TABLE = "app_hobbies";
    /** Join Table app_us_hobby. */
    public static final String JOIN_TABLE = "app_us_hobby";
    /** Table app_hobbies API description. */
    public static final String TABLE_API = "Describes a Hobby for our system.";


    // COLUMNS DEFINITION
    /** Column hobby_label.*/
    public static final String COL_LABEL = "hobby_label";
    /** Column eb_enabled API Description.*/
    public static final String COL_LABEL_API = "The hobby label to create.";
    /** Column hobby_label length. */
    public static final int COL_LABEL_LENGTH = 100;

    /** Mapped by "hobby".*/
    public static final String MAPPED_BY_HOBBY = "hobby";

}
