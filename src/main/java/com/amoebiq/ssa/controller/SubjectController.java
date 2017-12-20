package com.amoebiq.ssa.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.ssa.model.Subject;
import com.amoebiq.ssa.service.SubjectService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	private static final Logger logger = Logger.getLogger(SubjectController.class);

	@RequestMapping(path = "/new", method = POST)
	public ResponseEntity<Subject> newSubject(@RequestBody Subject subject) {

		logger.info("in new subject");

		return new ResponseEntity<Subject>(subjectService.newSubject(subject), HttpStatus.CREATED);

	}
	
	@RequestMapping(path="/all",method=GET)
	public ResponseEntity<List<Subject>> getAllSubjects() {
		
		logger.info("in all subjects");
		return new ResponseEntity<List<Subject>>(subjectService.getAllSubjects(),HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(path="/invalidate",method=PUT)
	public ResponseEntity<String> invalidateSubject(@RequestParam("subjectId") Long subjectId) {
		
		logger.info("in invalidate subject ::: "+subjectId);
		return new ResponseEntity<String>(subjectService.invalidateSubject(subjectId),HttpStatus.ACCEPTED);
	}

}
