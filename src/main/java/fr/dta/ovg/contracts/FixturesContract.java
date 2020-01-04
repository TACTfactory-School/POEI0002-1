/* Fixtures Contract class.
 * Define all constants 4 clean code.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.contracts;

import java.time.LocalDate;

/** FIXTURES CONTRACT - Constants Term.*/
public final class FixturesContract {

    /** Private empty constructor of FixturesContract.*/
    private FixturesContract() {
        // nothing here.
    }

    // REAL FIXTURES REFERENCES
    /** User fixtures entries number.*/
    public static final int NB_USERS = 100;
    /** User fixtures entries number minus one because Random() hit zero.*/
    public static final int NB_RAND = 99;
    /** User Rate value.*/
    public static final byte NB_STARS = 5;
    /** Number of default avatar choices.*/
    public static final byte NB_DEFAULT_AVATAR = 5;
    /** Random event future date scale.*/
    public static final int DATE_SCALE = 2000;

    // CREATORS INFORMATIONS.
    /** Samy ID.*/
    public static final byte SAMY = 1;
    /** Samy Birthdate.*/
    public static final LocalDate SAMY_BD = LocalDate.of(1998, 9, 25);
    /** Colin ID.*/
    public static final byte COLIN = 2;
    /** Colin Birthdate.*/
    public static final LocalDate COLIN_BD = LocalDate.of(1990, 06, 05);
    /** Fabrice ID.*/
    public static final byte FAB = 3;
    /** Fabrice Birthdate.*/
    public static final LocalDate FAB_BD =  LocalDate.of(1997, 04, 8);
    /** Test ID.*/
    public static final byte TEST = 4;
    /** TEST Birthdate.*/
    public static final LocalDate TEST_BD =  LocalDate.of(1999, 04, 8);
    /** Number of real build fixtures.*/
    public static final byte NB_REAL = 4;

    // HOBBY FIXTURES TERMS
    /** Number of initial real hobbies minus one (because random object can hit zero).*/
    public static final byte NB_HOBBIES = 15;

    // LANGUAGE FIXTURES TERMS
    /** Number of level choices minus one (because random object can hit zero).*/
    public static final byte NB_LEVELS = 4;
    /** Number of languages default choices minus one (because random object can hit zero).*/
    public static final byte NB_LANGS = 4;
    /** Language level BEGINNER ID.*/
    public static final byte LVL_BEGINNER = 0;
    /** Language level INTERMEDIATE ID.*/
    public static final byte LVL_INTERMEDIATE = 1;
    /** Language level ADVANCED ID.*/
    public static final byte LVL_ADVANCED = 2;
    /** Language level FLUENT ID.*/
    public static final byte LVL_FLUENT = 3;
    /** Language level NATIVE ID.*/
    public static final byte LVL_NATIVE = 4;

    // EVENT FIXTURE TERMS
    /** Samy ID.*/
    public static final byte NB_PLACES_25 = 25;
    /** Colin ID.*/
    public static final byte NB_PLACES_20 = 20;
    /** Fabrice ID.*/
    public static final byte NB_PLACES_15 = 15;
    /** Test ID.*/
    public static final byte NB_PLACES_5 = 5;

    // EVENT TYPE FIXTURES REFERENCES
    /** Event type Store length.*/
    public static final byte EV_TYPE_STORE_SIZE = 13;
    /** Event type ARCADE ID.*/
    public static final byte TYPE_ARCADE = 0;
    /** Event type BIRTHDAY ID.*/
    public static final byte TYPE_BIRTHDAY = 1;
    /** Event type COCKTAIL ID.*/
    public static final byte TYPE_COCKTAIL = 2;
    /** Event type CONFERENCE ID.*/
    public static final byte TYPE_CONFERENCE = 3;
    /** Event type ESPORT ID.*/
    public static final byte TYPE_ESPORT = 4;
    /** Event type FESTIVAL ID.*/
    public static final byte TYPE_FESTIVAL = 5;
    /** Event type LAN ID.*/
    public static final byte TYPE_LAN = 6;
    /** Event type RESTAURANT ID.*/
    public static final byte TYPE_RESTAURANT = 7;
    /** Event type RETROGAMING ID.*/
    public static final byte TYPE_RETROGAMING = 8;
    /** Event type SPORT ID.*/
    public static final byte TYPE_SPORT = 9;
    /** Event type THEMATICPARTY ID.*/
    public static final byte TYPE_THEMATICPARTY = 10;
    /** Event type TOURNAMENTS ID.*/
    public static final byte TYPE_TOURNAMENTS = 11;
    /** Event type VIDEOGAMES ID.*/
    public static final byte TYPE_VIDEOGAMES = 12;
    /** Event type OTHER ID.*/
    public static final byte TYPE_OTHER = 13;

    // UER STATUS FIXTURES REFERENCES
    /** User Status Store length ( minus one because random object can hit zero).*/
    public static final byte US_STATUS_STORE_SIZE = 4;
    /** User Status DIVORCED ID.*/
    public static final byte US_DIVORCED = 0;
    /** User Status ARCADE ID.*/
    public static final byte US_MARRIED = 1;
    /** User Status SINGLE ID.*/
    public static final byte US_SINGLE = 2;
    /** User Status WIDOWED ID.*/
    public static final byte US_WIDOWED = 3;
    /** User Status UNSPECIFIED ID.*/
    public static final byte US_UNSPECIFIED = 4;

    // UER GENDER FIXTURES REFERENCES
    /** User Gender Store length (minus one because random object can hit zero).*/
    public static final byte US_GENDER_STORE_SIZE = 3;
    /** User Gender UNSPECIFIED ID.*/
    public static final byte US_GENDER_FEMALE = 0;
    /** User Gender UNSPECIFIED ID.*/
    public static final byte US_GENDER_MALE = 1;
    /** User Gender UNSPECIFIED ID.*/
    public static final byte US_GENDER_NONBINARY = 2;
    /** User Gender UNSPECIFIED ID.*/
    public static final byte US_GENDER_UNSPECIFIED = 3;

    // UER FRIENDS FIXTURES REFERENCES
    /** Select one random friends to add.*/
    public static final byte US_FRIENDS_1 = 47;
    /** Select another one random friends to add.*/
    public static final byte US_FRIENDS_2 = 57;
    /** Select another one random friends to add.*/
    public static final byte US_FRIENDS_3 = 67;
    /** Select another one random friends to add.*/
    public static final byte US_FRIENDS_4 = 77;
}
