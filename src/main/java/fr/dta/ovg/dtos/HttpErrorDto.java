package fr.dta.ovg.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Model of content of response used in case of HTTP exception.
 *
 * @see GlobalExceptionHandler
 */
public class HttpErrorDto {
    /** The date of error generation. */
    private final Date timestamp;

    /** The error message. */
    private final String message;

    /** The details about the error. */
    private final String details;

    public HttpErrorDto(final Exception exception) {
        this(new Date(), exception.getMessage(), null);
    }

    public HttpErrorDto(final String message, final String details) {
        this(new Date(), message, details);
    }

    public HttpErrorDto(final Date timestamp, final String message, final String details) {
        super();

        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    @JsonInclude(value = Include.NON_NULL)
    public String getDetails() {
        return this.details;
    }
}
