package com.amoebiq.ssa.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.amoebiq.ssa.model.ApplicationUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static com.amoebiq.ssa.constants.SecurityConstants.HEADER_STRING;
import static com.amoebiq.ssa.constants.SecurityConstants.EXPIRATION_TIME;
import static com.amoebiq.ssa.constants.SecurityConstants.SECRET;
import static com.amoebiq.ssa.constants.SecurityConstants.SIGN_UP_URL;
import static com.amoebiq.ssa.constants.SecurityConstants.TOKEN_PREFIX;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private static final Logger logger = LogManager.getLogger(JWTAuthenticationFilter.class);
	
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {

		this.authenticationManager = authenticationManager;

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		logger.info("Trying to login");
		try {

			ApplicationUser creds = new ObjectMapper().readValue(request.getInputStream(), ApplicationUser.class);
			logger.info("Login for user ::: "+creds.getUserName());
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getUserName(),
					creds.getPassword(), new ArrayList<>()));

		} catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String token = Jwts.builder().setSubject(((User) authResult.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

	}

}
