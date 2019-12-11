/* Global Exception Handler Configuration Class.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
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
 * Global Exception Handler. <br>
 * Treats common exception handlers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Bad Request Exception.
     * @param e Exception.
     * @return Response Entity.
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestExceptionHandler(final Exception e) {
        return this.build(HttpStatus.BAD_REQUEST, e);
    }


    /**
     * Not Found Exception.
     * @param e Exception.
     * @return Response Entity.
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundExceptionHandler(final Exception e) {
        return this.build(HttpStatus.NOT_FOUND, e);
    }

    /**
     * Not Yet Implemented Exception.
     * @param e Exception.
     * @return Response Entity.
     */
    @ExceptionHandler(NotYetImplementedException.class)
    public ResponseEntity<?> notImplementedExceptionHandler(final Exception e) {
        return this.build(HttpStatus.NOT_IMPLEMENTED, e);
    }

    /**
     * Global Exception handler .
     * @param e Exception.
     * @param request WebRequest
     * @return Response Entity.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(final Exception e, final WebRequest request) {
        return this.build(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

    /**
     * Build response entity.
     * @param status HttpStatus
     * @param e Exception
     * @return ResponseEntity
     */
    private ResponseEntity<?> build(final HttpStatus status, final Exception e) {
        return ResponseEntity
                .status(status)
                .body(new HttpErrorDto(e));
    }
}
