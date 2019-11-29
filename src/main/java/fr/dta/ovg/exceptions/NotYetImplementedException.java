package fr.dta.ovg.exceptions;

public class NotYetImplementedException extends Exception {

    private static final long serialVersionUID = 1L;

    /** The default constructor. */
    public NotYetImplementedException() {
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public NotYetImplementedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public NotYetImplementedException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public NotYetImplementedException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public NotYetImplementedException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
