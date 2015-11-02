package com.rakuten.products.utils.converters;

import com.rakuten.products.beans.User;
import com.rakuten.products.dto.UserDto;

/**
 * This is a utility class to convert between user to userDto and vise versa
 * 
 * @author Gasser
 * 
 */
public class UserConverter {

	/**
	 * This method used to convert user object to its DTO.
	 * 
	 * @param user
	 * @return
	 */
	public static UserDto convertUserToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setUserName(user.getUsername());

		return userDto;
	}

}
