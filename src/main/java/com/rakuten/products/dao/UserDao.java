package com.rakuten.products.dao;

import com.rakuten.products.beans.User;

/**
 * The Interface UserDao.
 * @author Gasser
 */
public interface UserDao {

	/**
	 * Gets the user.
	 * 
	 * @param username
	 *            the username
	 * @return the user
	 */
	User getUser(String username);

	/**
	 * Authenticate.
	 * 
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return true, if successful
	 */
	boolean authenticate(String username, String password);

}
