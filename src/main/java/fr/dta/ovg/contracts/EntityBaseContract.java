/* EntityBase Contract class.
 * Define all constants 4 clean code.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.contracts;

/** ENTITY BASE CONTRACT - Constants Term. MappedSuperClass.*/
public class EntityBaseContract {

    /** Private empty constructor of EntityBaseContract.*/
    private EntityBaseContract() {
        // nothing here.
    }

    // COLUMNS DEFINITION
    /** Column ID GenerationType.IDENTITY. API Description.*/
    public static final String COL_ID_API = "The generated database ID.";

    /** Column eb_enabled.*/
    public static final String COL_ENABLED = "eb_enabled";
    /** Column eb_enabled API Description.*/
    public static final String COL_ENABLED_API = "Specifies if the entity if enabled or not.";

    /** Column eb_created_at.*/
    public static final String COL_CREATED_AT = "eb_created_at";
    /** Column eb_created_at API Description.*/
    public static final String COL_CREATED_AT_API = "The generated date of creation.";

    /** Column eb_updated_at.*/
    public static final String COL_UPDATED_AT = "eb_updated_at";
    /** Column eb_updated_at API Description.*/
    public static final String COL_UPDATED_AT_API = "The updated date of entity.";

}
