package com.rakuten.products.dao;

import com.rakuten.products.beans.User;

/**
 * UserDao
 * 
 * @author Gasser
 * 
 */
public interface UserDao {

	/**
	 * This method used to get user details object by accepting username
	 * 
	 * @param username
	 * @return User
	 * @throws Exception
	 */
	public User getUser(String username) throws Exception;

	/**
	 * This method used to authenticate users for login
	 * 
	 * @param username
	 * @param password
	 * @return Boolean
	 * @throws Exception
	 */
	public boolean authenticate(String username, String password) throws Exception;

}
