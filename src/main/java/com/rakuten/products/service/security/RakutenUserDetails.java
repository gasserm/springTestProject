package com.rakuten.products.service.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.rakuten.products.dto.UserDto;


@SuppressWarnings("deprecation")
public class RakutenUserDetails extends org.springframework.security.core.userdetails.User{

	private static final long serialVersionUID = 1L;
	private UserDto user;
	

	public RakutenUserDetails(UserDto user, boolean isAuthenticatedUser) {
		super(user.getUserName(), "", true, true, true, true, toAuthorities(isAuthenticatedUser));
		this.setUser(user);
	}

	private static Collection<GrantedAuthority> toAuthorities(boolean isAuthenticatedUser) {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		if(isAuthenticatedUser)
			auths.add(new GrantedAuthorityImpl("ROLE_USER") );
		else
			auths.add(new GrantedAuthorityImpl("NOT_USER") );
		
		return auths;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public UserDto getUser() {
		return user;
	}
}
