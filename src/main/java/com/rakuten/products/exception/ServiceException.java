package com.rakuten.products.exception;

/**
 * The Class ServiceException.
 * @author Gasser
 */
public class ServiceException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new service exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
