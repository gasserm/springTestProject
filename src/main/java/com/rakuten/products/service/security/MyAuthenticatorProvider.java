package com.rakuten.products.service.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.rakuten.products.dto.UserDto;
import com.rakuten.products.exception.ServiceException;

/**
 * MyAuthenticatorProvider which is used for spring authentication and extending
 * AbstractUserDetailsAuthenticationProvider
 * 
 * @author Gasser
 * 
 */
public class MyAuthenticatorProvider extends AbstractUserDetailsAuthenticationProvider {

	private SecurityService securityService;

	public SecurityService getSecurityService() {
		return securityService;
	}

	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	}

	@SuppressWarnings("unused")
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		boolean isAuthenticatedUser = false;
		try {
			isAuthenticatedUser = securityService.authenticate(authentication.getPrincipal().toString(), authentication
					.getCredentials().toString());

			UserDto user = securityService.getUserDetails(authentication.getPrincipal().toString());
			return new RakutenUserDetails(user, isAuthenticatedUser);

		} catch (ServiceException e) {
			return null;
		}

	}

}