/* Http Error DTO Class.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
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

    /**
     * Http Error DTO Exception.
     * @param exception Exception.
     */
    public HttpErrorDto(final Exception exception) {
        this(new Date(), exception.getMessage(), null);
    }

    /**
     * Http Error DTO Message & Detail.
     * @param message String.
     * @param details String.
     */
    public HttpErrorDto(final String message, final String details) {
        this(new Date(), message, details);
    }

    /**
     * Http Error DTO Date, Message & Detail.
     * @param timestamp Date.
     * @param message String.
     * @param details String.
     */
    public HttpErrorDto(final Date timestamp, final String message, final String details) {
        super();

        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    /**
     * Getter Date.
     * @return Date timestamp.
     */
    public Date getTimestamp() {
        return this.timestamp;
    }

    /**
     * Getter Message.
     * @return String message.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Getter Details.
     * @return Date timestamp, String Message & String Detail.
     */
    @JsonInclude(value = Include.NON_NULL)
    public String getDetails() {
        return this.details;
    }
}
