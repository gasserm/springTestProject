package com.rakuten.products.service.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rakuten.products.beans.User;
import com.rakuten.products.dao.UserDao;
import com.rakuten.products.dto.UserDto;
import com.rakuten.products.utils.converters.UserConverter;

/**
 * The Class SecurityServiceImpl.
 * @author Gasser
 */
public class SecurityServiceImpl implements SecurityService {

	/** The user dao. */
	private UserDao userDao;

	/*
	 * @see
	 * com.rakuten.products.service.security.SecurityService#authenticate(java
	 * .lang.String, java.lang.String)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rakuten.products.service.security.SecurityService#authenticate(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	public Boolean authenticate(String username, String password) throws AuthenticationException {
		boolean autenticated = false;
		try {
			autenticated = userDao.authenticate(username, password);
		} catch (AuthenticationException e) {
			throw e;
		}

		return autenticated;
	}

	/*
	 * @see
	 * com.rakuten.products.service.security.SecurityService#getUserDetails(
	 * java.lang.String)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rakuten.products.service.security.SecurityService#getUserDetails(
	 * java.lang.String)
	 */
	@Override
	public UserDto getUserByUsername(String username) throws AuthenticationException {
		try {
			User user = userDao.getUser(username);
			if (user == null)
				throw new UsernameNotFoundException("couldn't get user by usernail as it doesn't exist");
			
			return UserConverter.convertUserToUserDto(user);
		} catch (AuthenticationException e) {
			throw e;
		}

	}

	/**
	 * Gets the user dao.
	 * 
	 * @return the user dao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * Sets the user dao.
	 * 
	 * @param userDao
	 *            the new user dao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
