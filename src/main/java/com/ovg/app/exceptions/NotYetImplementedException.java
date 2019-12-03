package com.ovg.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class NotYetImplementedException extends HttpException {

    /** The serial number. */
    private static final long serialVersionUID = 1L;

    public NotYetImplementedException() {
    }

    public NotYetImplementedException(String message) {
        super(message);
    }

    public NotYetImplementedException(Throwable cause) {
        super(cause);
    }

    public NotYetImplementedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotYetImplementedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
