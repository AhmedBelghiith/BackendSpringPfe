package com.bandsmile.crud.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;

@Component
public class WebSocketAuthenticatorService {
	@Autowired
	@Qualifier("jwtUserDetailsService")
	UserDetailsService userDetailsService;

	// This method MUST return a UsernamePasswordAuthenticationToken instance, the
	// spring security chain is testing it with 'instanceof' later on. So don't use
	// a subclass of it or any other class
	public UsernamePasswordAuthenticationToken getAuthenticatedOrFail(final String username)
			throws AuthenticationException {
		if (username == null || username.trim().isEmpty()) {
			throw new AuthenticationCredentialsNotFoundException("Username was null or empty.");
		}
		UserDetails userDetails;
		userDetails = userDetailsService.loadUserByUsername(username);
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}
}
