package com.rakuten.products.service.security;

import com.rakuten.products.beans.User;
import com.rakuten.products.dao.UserDao;
import com.rakuten.products.dto.UserDto;
import com.rakuten.products.exception.ServiceException;
import com.rakuten.products.utils.converters.UserConverter;

/**
 * This is the implementation class for SecurityService
 * 
 * @author Gasser
 * 
 */
public class SecurityServiceImpl implements SecurityService {
	private UserDao userDao;

	/*
	 * @see
	 * com.rakuten.products.service.security.SecurityService#authenticate(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	public Boolean authenticate(String username, String password) throws ServiceException {
		boolean autenticated = false;
		try {
			autenticated = userDao.authenticate(username, password);
		} catch (Exception e) {
			throw new ServiceException("faild to authenticate user : " + username, e);
		}

		return autenticated;
	}

	/*
	 * @see
	 * com.rakuten.products.service.security.SecurityService#getUserDetails(
	 * java.lang.String)
	 */
	@Override
	public UserDto getUserDetails(String username) throws ServiceException {
		try {
			User user = userDao.getUser(username);
			return UserConverter.convertUserToUserDto(user);
		} catch (Exception e) {
			throw new ServiceException("failed to get user with username : " + username, e);
		}

	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
