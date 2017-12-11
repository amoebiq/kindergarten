package com.amoebiq.ssa.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.amoebiq.ssa.masterresponse.Metrics;
import com.amoebiq.ssa.masterresponse.SuperClassResponse;
import com.amoebiq.ssa.model.School;
import com.amoebiq.ssa.service.SchoolService;

@RestController
@RequestMapping(path = "/schools")
public class SchoolController {

	private static final Logger logger = LogManager.getLogger(SchoolController.class);
	@Autowired
	private SchoolService schoolService;

	@GetMapping("all")
	public ResponseEntity<List<School>> getAllSchools() {

		logger.info("INFO - In school controller");
		return new ResponseEntity<List<School>>(schoolService.getAllSchools(), HttpStatus.OK);
	}
	
	@GetMapping("allTest")
	public ResponseEntity<List<School>> getAllSchoolsTest() {

		logger.info("INFO - In school controller");
		List<School> schools = schoolService.getAllSchools();
		Metrics metrics = new Metrics();
		metrics.setCpu(12);
		metrics.setMemory(14);
		metrics.setStorage(16);
		
		//SuperClassResponse<School> scr = new SuperClassResponse<School>(metrics, schools);
		return new ResponseEntity<List<School>>(schoolService.getAllSchools(), HttpStatus.OK);
	}
	
	@GetMapping("school/{id}")
	public ResponseEntity<School> getSchool(@PathVariable("id") String schoolId) {
		logger.info("School id ::: "+schoolId);
		return new ResponseEntity<School>(schoolService.getSchool(schoolId), HttpStatus.OK);
	}
	
	@PostMapping("new")
	public ResponseEntity<Void> addSchool(@RequestBody School school , UriComponentsBuilder uriComponents) {
		
		logger.info("New School to be added :::"+school.getSchoolName());
		schoolService.addSchool(school);
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.path("/school/{id}").buildAndExpand(school.getSchoolId()).toUri());
       
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		
	}

}
