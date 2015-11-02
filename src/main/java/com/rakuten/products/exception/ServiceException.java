package com.rakuten.products.exception;

/**
 * @author Gasser
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This constructor to create a ServiceException using message and cause
	 * 
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
