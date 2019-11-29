package fr.dta.ovg.configurations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import fr.dta.ovg.dtos.HttpErrorDto;
import fr.dta.ovg.exceptions.BadRequestException;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.exceptions.NotYetImplementedException;

/**
 * Treats common exception handlers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestExceptionHandler(final Exception e) {
        return this.build(HttpStatus.BAD_REQUEST, e);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundExceptionHandler(final Exception e) {
        return this.build(HttpStatus.NOT_FOUND, e);
    }

    @ExceptionHandler(NotYetImplementedException.class)
    public ResponseEntity<?> notImplementedExceptionHandler(final Exception e) {
        return this.build(HttpStatus.NOT_IMPLEMENTED, e);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(final Exception e, final WebRequest request) {
        return this.build(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

    private ResponseEntity<?> build(final HttpStatus status, final Exception e) {
        return ResponseEntity
                .status(status)
                .body(new HttpErrorDto(e));
    }
}
