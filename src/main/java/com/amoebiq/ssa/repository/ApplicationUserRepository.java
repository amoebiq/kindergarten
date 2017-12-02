package com.amoebiq.ssa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amoebiq.ssa.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{
	
	ApplicationUser findByUserName(String userName);

}
