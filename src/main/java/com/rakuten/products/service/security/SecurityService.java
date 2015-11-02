package com.rakuten.products.service.security;

import com.rakuten.products.dto.UserDto;
import com.rakuten.products.exception.ServiceException;

/**
 * This class used to hold security methods inside the application
 * 
 * @author Gasser
 *
 */
public interface SecurityService {

	/**
	 * This method used to authenticate users for login
	 * @param username
	 * @param password
	 * @return Boolean
	 * @throws ServiceException
	 */
	public Boolean authenticate(String username, String password) throws ServiceException;
	
	/**
	 * This method used to get user details object by accepting username
	 * @param username
	 * @return UserDto
	 * @throws ServiceException
	 */
	public UserDto getUserDetails(String username) throws ServiceException;
	
}
