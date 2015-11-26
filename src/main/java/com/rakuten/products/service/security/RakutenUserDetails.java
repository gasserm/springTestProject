package com.rakuten.products.service.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.rakuten.products.dto.UserDto;


/**
 * The Class RakutenUserDetails.
 * @author Gasser
 */
public class RakutenUserDetails extends org.springframework.security.core.userdetails.User{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The user. */
	private UserDto user;
	

	/**
	 * Instantiates a new rakuten user details.
	 * 
	 * @param user
	 *            the user
	 * @param isAuthenticatedUser
	 *            the is authenticated user
	 */
	public RakutenUserDetails(UserDto user, boolean isAuthenticatedUser) {
		super(user.getUserName(), "", true, true, true, true, toAuthorities(isAuthenticatedUser));
		this.setUser(user);
	}

	/**
	 * To authorities.
	 * 
	 * @param isAuthenticatedUser
	 *            the is authenticated user
	 * @return the collection
	 */
	private static Collection<GrantedAuthority> toAuthorities(boolean isAuthenticatedUser) {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		if(isAuthenticatedUser)
			auths.add(new GrantedAuthorityImpl("ROLE_USER") );
		else
			auths.add(new GrantedAuthorityImpl("NOT_USER") );
		
		return auths;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(UserDto user) {
		this.user = user;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public UserDto getUser() {
		return user;
	}
}
