/**
 *
 */
package fr.dta.ovg.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author JoeHarms
 *
 */


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends HttpException {

    /** The serial number. */
    private static final long serialVersionUID = 1L;

    /** The default constructor. */
    public BadRequestException() {
    }

    public BadRequestException(final String message) {
        super(message);
    }

    public BadRequestException(final Throwable cause) {
        super(cause);
    }

    public BadRequestException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(final String message, final Throwable cause, final boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
