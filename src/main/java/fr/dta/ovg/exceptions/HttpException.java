package fr.dta.ovg.exceptions;

//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class HttpException extends Exception {

  /** The serial number. */
  private static final long serialVersionUID = 1L;

  /** The default constructor. */
  public HttpException() {
      super();
  }

  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public HttpException(final String message, final Throwable cause, final boolean enableSuppression,
          final boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * @param message
   * @param cause
   */
  public HttpException(final String message, final Throwable cause) {
      super(message, cause);
  }

  /**
   * @param message
   */
  public HttpException(final String message) {
      super(message);
  }

  /**
   * @param cause
   */
  public HttpException(final Throwable cause) {
      super(cause);
  }
}
