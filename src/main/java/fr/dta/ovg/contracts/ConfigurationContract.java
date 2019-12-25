/* Configuration Contract class.
 * Define all constants 4 clean code.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.contracts;

/** CONFIGURATION CONTRACT - Constants Term.*/
public final class ConfigurationContract {

    /** Private empty constructor of ConfigurationContract.*/
    private ConfigurationContract() {
        // nothing here.
    }

    // CORS CONFIGURATION
    /** ADD MAPPING Path.*/
    public static final String CORS_ADD_MAPPING = "/**";
    /** ALLOWED ORIGINS Path.*/
    public static final String CORS_ALLOWED_ORIGINS = "*";
    /** ALLOWED HEADERS Path.*/
    public static final String CORS_ALLOWED_HEADERS = "*";
    /** ALLOWED METHODS GET.*/
    public static final String CORS_ALLOW_GET = "GET";
    /** ALLOWED METHODS PUT.*/
    public static final String CORS_ALLOW_PUT = "PUT";
    /** ALLOWED METHODS POST.*/
    public static final String CORS_ALLOW_POST = "POST";
    /** ALLOWED METHODS PATCH.*/
    public static final String CORS_ALLOW_PATCH = "PATCH";
    /** ALLOWED METHODS DELETE.*/
    public static final String CORS_ALLOW_DELETE = "DELETE";
    /** ALLOWED METHODS OPTIONS.*/
    public static final String CORS_ALLOW_OPTIONS = "OPTIONS";

    // CONTROLLER CONFIGURATION
    /** NOT FOUND EXCEPTION DATE PARAM.*/
    public static final String CONTROLLER_404_DATE = "date";
    /** NOT FOUND EXCEPTION ERROR PARAM.*/
    public static final String CONTROLLER_404_ERROR = "error";

    // OPEN API CONFIGURATION
    /** BASE PACKAGE PATTERN.*/
    public static final String API_BASE_PACKAGE = "fr.dta.ovg";
    /** API Info Title.*/
    public static final String API_INFO_TITLE = "OVG API documentation.";
    /** API Info Description.*/
    public static final String API_INFO_DESCRIPTION = "Documentation of the back-end API of On Va Geeker.";
    /** API Info License.*/
    public static final String API_INFO_LICENSE = "© Tous droits réservés.";
    /** API Info License URL.*/
    public static final String API_INFO_LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0.html";
    /** API Info Version.*/
    public static final String API_INFO_VERSION = "1.0.0";

    // SECURITY CONFIGURATION
    /** HTTP Security AntMatcher URI : /api/v1/event.*/
    public static final String REQUEST_URI_EVENT = "/api/v1/event";
    /** HTTP Security AntMatcher URI : /api/v1/user.*/
    public static final String REQUEST_URI_USER = "/api/v1/user";
    /** HTTP Security AntMatcher URI : /api/v1/user/me.*/
    public static final String REQUEST_URI_USER_ME = "/api/v1/user/me";
    /** HTTP Security AntMatcher URI : /api/v1/message.*/
    public static final String REQUEST_URI_MESSAGE = "/api/v1/message";
    /** HTTP Security AntMatcher URI : /api/v1/language.*/
    public static final String REQUEST_URI_LANGUAGE = "/api/v1/language";
    /** HTTP Security AntMatcher URI : /api/v1/hobby.*/
    public static final String REQUEST_URI_HOBBY = "/api/v1/hobby";
    /** HTTP Security AntMatcher URI : /api/v1/join.*/
    public static final String REQUEST_URI_JOIN = "/api/v1/join";
}
