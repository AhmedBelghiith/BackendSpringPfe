package com.bandsmile.crud.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;


public class JwtAuthentication {
	
	@ExceptionHandler({ AuthenticationException.class })
	public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}

	/**
	 * Authenticates the user. If something is wrong, an
	 * {@link AuthenticationException} will be thrown
	 * 
	 * @throws AuthenticationException
	 * @throws IOException 
	 */
	public  void validAccess(AuthenticationManager authenticationManager,String email, String password) throws AuthenticationException, IOException {
		Objects.requireNonNull(email);
		Objects.requireNonNull(password);
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new AuthenticationException("User is disabled!");
			
		} catch (BadCredentialsException e) {
			System.out.println(e);
			throw new AuthenticationException("Bad credentials!");
			
		}
	}
	
	public String generateAccess(JwtTokenUtil jwtTokenUtil ,UserDetails userDetails)
	{
			return jwtTokenUtil.generateToken(userDetails);
	}
	public Date getExpirationDate(JwtTokenUtil jwtTokenUtil,String token) {
		return jwtTokenUtil.getExpirationDateFromToken(token);
	}
	public String getUsernameFromToken(JwtTokenUtil jwtTokenUtil,String token)
	{
		return jwtTokenUtil.getUsernameFromToken(token);
	}
	public boolean canTokenBeRefreshed(JwtTokenUtil jwtTokenUtil,String token,Date Lastrestpassword) 	
	{
		return jwtTokenUtil.canTokenBeRefreshed(token, Lastrestpassword);
	}
	public String refreshToken(JwtTokenUtil jwtTokenUtil,String token)
	{
		return jwtTokenUtil.refreshToken(token);
	}
}
