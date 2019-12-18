/* HTTP Exception Class.
 * Custom exception.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.exceptions; // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

/** HTTP Exception Class.*/
public class HttpException extends Exception {

  /** The serial number. */
  private static final long serialVersionUID = 1L;

  /** The default constructor. */
  public HttpException() {
      super();
  }

  /** Full Constructor with message, cause, suppression option & stack trace options.
   * @param message : (String) : message to return.
   * @param cause:  cause to return. @see Throwable.
   * @param enableSuppression : enable suppression option.
   * @param writableStackTrace Stack trace option.*/
  public HttpException(final String message, final Throwable cause, final boolean enableSuppression,
          final boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
  }

  /** Constructor with message and cause parameters.
   * @param message : (String) : message to return.
   * @param cause : cause to return. @see Throwable.*/
  public HttpException(final String message, final Throwable cause) {
      super(message, cause);
  }

  /** Constructor with message parameter.
   * @param message (String) : message to return.*/
  public HttpException(final String message) {
      super(message);
  }

  /** Constructor with cause parameter.
   * @param cause : cause to return. @see Throwable.*/
  public HttpException(final Throwable cause) {
      super(cause);
  }
}
