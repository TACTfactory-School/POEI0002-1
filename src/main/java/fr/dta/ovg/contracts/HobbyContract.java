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

    // TABLE DEFINITION
    /** Table app_hobbies. */
    public static final String TABLE = "app_hobbies";
    /** Table app_hobbies API description. */
    public static final String TABLE_API = "Describes a Hobby for our system.";


    // COLUMNS DEFINITION
    /** Column hobby_label.*/
    public static final String COL_LABEL = "hobby_label";
    /** Column eb_enabled API Description.*/
    public static final String COL_LABEL_API = "The hobby label to create.";

    /** Mapped by "hobby".*/
    public static final String MAPPED_BY_HOBBY = "hobby";

}
