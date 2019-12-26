/* NotYetImplemented Exception Class.
 * Custom exception.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */

package fr.dta.ovg.exceptions;

/** NotYetImplemented Exception Class.*/
public class NotYetImplementedException extends Exception {

    private static final long serialVersionUID = 1L;

    /** The default constructor. */
    public NotYetImplementedException() {
    }

    /** Full Constructor with message, cause, suppression and stack trace options.
     * @param message (String) : message to return.
     * @param cause : cause to return. @see Throwable.
     * @param enableSuppression : enable suppression option.
     * @param writableStackTrace : Stack trace option.*/
    public NotYetImplementedException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    /** Constructor with message and cause parameters.
     * @param message (String) : message to return.
     * @param cause : cause to return. @see Throwable.*/
    public NotYetImplementedException(final String message, final Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /** Constructor with message parameter.
     * @param message (String) : message to return.*/
    public NotYetImplementedException(final String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /** Constructor with cause parameter.
     * @param cause : cause to return. @see Throwable.*/
    public NotYetImplementedException(final Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
