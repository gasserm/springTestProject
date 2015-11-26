package com.rakuten.products.service.security;

import org.springframework.security.core.AuthenticationException;

import com.rakuten.products.dto.UserDto;
import com.rakuten.products.exception.ServiceException;

/**
 * The Interface SecurityService.
 * @author Gasser
 */
public interface SecurityService {

	/**
	 * Authenticate.
	 * 
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the boolean
	 * @throws ServiceException
	 *             the service exception
	 */
	public Boolean authenticate(String username, String password) throws AuthenticationException;
	
	/**
	 * Gets the user by username.
	 * 
	 * @param username
	 *            the username
	 * @return the user by username
	 * @throws ServiceException
	 *             the service exception
	 */
	public UserDto getUserByUsername(String username) throws AuthenticationException;
	
}
