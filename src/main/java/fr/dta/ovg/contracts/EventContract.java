/* Event Contract class.
 * Define all constants 4 clean code.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.contracts;

/** EVENT CONTRACT - Constants Term.*/
public class EventContract {

    /** Private empty constructor of EventContract.*/
    private EventContract() {
        // nothing here.
    }

    // TABLE DEFINITION
    /** Table app_events. */
    public static final String TABLE = "app_events";
    /** Table app_events API description. */
    public static final String TABLE_API = "Describes an Event for our system.";

    // COLUMNS DEFINITION
    /** Column Creator API Description. */
    public static final String COL_CREATOR_API = "The author of the event.";
    public static final String COL_CREATOR_JSONIGNORE = "ev_label";

    /** Column ev_label. */
    public static final String COL_LABEL = "ev_label";
    /** Column ev_label API Description. */
    public static final String COL_LABEL_API = "The label of the event.";

    /** Column ev_description. */
    public static final String COL_DESC = "ev_description";
    /** Column ev_description API Description. */
    public static final String COL_DESC_API = "The description of the event.";

    /** Column ev_start_date. */
    public static final String COL_START_DATE = "ev_start_date";
    /** Column ev_start_date API Description. */
    public static final String COL_START_DATE_API = "The started time date of the event.";

    /** Column ev_img. */
    public static final String COL_IMG = "ev_img";
    /** Column ev_img API Description. */
    public static final String COL_IMG_API = "The custom picture of the event." ;

    /** Column ev_nbplaces_max. */
    public static final String COL_NB_PLACES = "ev_nbplaces_max";
    /** Column ev_nbplaces_max API Description. */
    public static final String COL_NB_PLACES_API = "Th max places amount of the event." ;

    /** Column ev_address. */
    public static final String COL_ADDRESS = "ev_address";
    /** Column ev_address API Description. */
    public static final String COL_ADDRESS_API = "The place of the event.";

    /** Column ev_postcode. */
    public static final String COL_POSTCODE = "ev_postcode";
    /** Column ev_postcode API Description. */
    public static final String COL_POSTCODE_API = "The city postcode of the event.";

    /** Column ev_city. */
    public static final String COL_CITY = "ev_city";
    /** Column ev_city API Description. */
    public static final String COL_CITY_API = "The city of the event.";

    /** Column ev_type. */
    public static final String COL_TYPE = "ev_type";
    /** Column ev_ype API Description. */
    public static final String COL_TYPE_API = "The type of the event.";


    /** Mapped by "event".*/
    public static final String MAPPED_BY_EVENT = "event";

    /** Override to String function for app_events. */
    public static final String TO_STRING = "| Title : %s "
                                        + "| Description : %s "
                                        + "| Creator : %s "
                                        + "| Finished : %b "
                                        + "| Start Date : %dt "
                                        + "| Max places : %d "
                                        + "| Address : %s "
                                        + "| Postcode : %s "
                                        + "| City: %s ";
}
