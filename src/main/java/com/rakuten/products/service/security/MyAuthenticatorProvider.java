package com.rakuten.products.service.security;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rakuten.products.dto.UserDto;

/**
 * The Class MyAuthenticatorProvider.
 * @author Gasser
 */
public class MyAuthenticatorProvider extends AbstractUserDetailsAuthenticationProvider {

	/** The security service. */
	private SecurityService securityService;

	/**
	 * Gets the security service.
	 * 
	 * @return the security service
	 */
	public SecurityService getSecurityService() {
		return securityService;
	}

	/**
	 * Sets the security service.
	 * 
	 * @param securityService
	 *            the new security service
	 */
	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.authentication.dao.
	 * AbstractUserDetailsAuthenticationProvider
	 * #additionalAuthenticationChecks(org
	 * .springframework.security.core.userdetails.UserDetails,
	 * org.springframework
	 * .security.authentication.UsernamePasswordAuthenticationToken)
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.authentication.dao.
	 * AbstractUserDetailsAuthenticationProvider#retrieveUser(java.lang.String,
	 * org
	 * .springframework.security.authentication.UsernamePasswordAuthenticationToken
	 * )
	 */
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		boolean isAuthenticatedUser = false;
		UserDto user = null;
		try {

			isAuthenticatedUser = securityService.authenticate(authentication.getPrincipal().toString(), authentication
					.getCredentials().toString());

			user = securityService.getUserByUsername(authentication.getPrincipal().toString());

			if (user == null)
				throw new AuthenticationServiceException(
						"UserDetailsService returned null, which is an interface contract violation");

		} catch (UsernameNotFoundException notFound) {
			throw notFound;
		} catch (AuthenticationException e) {
			throw e;
		}
		return new RakutenUserDetails(user, isAuthenticatedUser);

	}

}