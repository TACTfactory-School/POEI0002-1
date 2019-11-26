package fr.dta.ovg.exceptions;

//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class HttpException extends Exception {

  /** The serial number. */
  private static final long serialVersionUID = 1L;

  /**
   *
   */
  public HttpException() {
      super();
  }

  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public HttpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * @param message
   * @param cause
   */
  public HttpException(String message, Throwable cause) {
      super(message, cause);
  }

  /**
   * @param message
   */
  public HttpException(String message) {
      super(message);
  }

  /**
   * @param cause
   */
  public HttpException(Throwable cause) {
      super(cause);
  }
}
