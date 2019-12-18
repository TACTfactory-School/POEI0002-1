/* BadRequest Exception Class.
 * Custom exception.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */

package fr.dta.ovg.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** BadRequest Exception Class.<br>Custom HttpException exception definition @see HttpException.*/
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends HttpException {

    /** The serial number. */
    private static final long serialVersionUID = 1L;

    /** The default constructor. */
    public BadRequestException() {
    }

    /** Constructor with message parameter.
     * @param message (String) : message to return.
     */
    public BadRequestException(final String message) {
        super(message);
    }

    /** Constructor with cause parameter.
     * @param cause : cause to return. @see Throwable.*/
    public BadRequestException(final Throwable cause) {
        super(cause);
    }

    /** Constructor with message and cause parameters.
     * @param message (String) : message to return.
     * @param cause : cause to return. @see Throwable.*/
    public BadRequestException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /** Full Constructor with message, cause, suppression option & stack trace parameters.
     * @param message (String) : message to return.
     * @param cause : cause to return. @see Throwable.
     * @param enableSuppression : enable suppression option.
     * @param writableStackTrace : Stack trace option.*/
    public BadRequestException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
