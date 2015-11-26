package com.rakuten.products.utils.converters;

import com.rakuten.products.beans.User;
import com.rakuten.products.dto.UserDto;

// TODO: Auto-generated Javadoc
/**
 * The Class UserConverter.
 */
public class UserConverter {

	/**
	 * Convert user to user dto.
	 * 
	 * @param user
	 *            the user
	 * @return the user dto
	 */
	public static UserDto convertUserToUserDto(User user) {

		if (user != null) {
			UserDto userDto = new UserDto();
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setUserName(user.getUsername());

			return userDto;
		} else
			return null;
	}

}
