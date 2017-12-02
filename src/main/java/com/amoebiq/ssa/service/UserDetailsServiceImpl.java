package com.amoebiq.ssa.service;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.model.ApplicationUser;
import com.amoebiq.ssa.repository.ApplicationUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class);
	
	private ApplicationUserRepository applicationUserRepository;

	public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {

		this.applicationUserRepository = applicationUserRepository;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.info("Getting info for user ::: "+username);
		
		ApplicationUser applicationUser = applicationUserRepository.findByUserName(username);

		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(applicationUser.getUserName(), applicationUser.getPassword(), new ArrayList<>());

	}

}
