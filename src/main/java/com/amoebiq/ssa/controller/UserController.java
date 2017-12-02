package com.amoebiq.ssa.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.ssa.model.ApplicationUser;
import com.amoebiq.ssa.repository.ApplicationUserRepository;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	private ApplicationUserRepository applicationUserRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserController(ApplicationUserRepository applicationUserRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		
		this.applicationUserRepository = applicationUserRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
	}
	
	@PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
		logger.info("In sign up for user ::: "+user.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

}
