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
    public NotYetImplementedException(final String message, final Throwable cause, final boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public NotYetImplementedException(final String message, final Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public NotYetImplementedException(final String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public NotYetImplementedException(final Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
