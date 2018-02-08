package com.amoebiq.ssa.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.ssa.model.Teachers;
import com.amoebiq.ssa.service.TeacherService;

@RestController
@RequestMapping(path="teachers")

public class TeachersController {
	
	private static final Logger logger = LogManager.getLogger(TeachersController.class);
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Teachers>> getAllTeachers() {
		
		return new ResponseEntity<List<Teachers>>(teacherService.findAllTeachers(),HttpStatus.OK);
		
	}
	
	@PostMapping("/teacher/new")
	public ResponseEntity<Teachers> newTeacher(@RequestBody Teachers teachers) {
		teacherService.addTeacher(teachers);
		logger.info("Id:::: " +teachers.getId());
		return new ResponseEntity<Teachers>(teacherService.findATeacher(teachers.getId()),HttpStatus.CREATED);
	}
	
	@PutMapping("/teacher/{id}")
	public ResponseEntity<Teachers> updateTeacher(@PathVariable("id") Long teacherId , @RequestBody Teachers teachers) {
		
		logger.info("Updating the teacher record ::: "+teacherId);
		teachers.setId(teacherId);
		return new ResponseEntity<Teachers>(teacherService.updateRecord(teacherId, teachers),HttpStatus.ACCEPTED);
		
	}
	@PutMapping("/teacher/{id}")
	public ResponseEntity<Teachers> updateTeacherA(@PathVariable("id") Long teacherId , @RequestBody Teachers teachers) {
		
		logger.info("Updating the teacher record ::: "+teacherId);
		teachers.setId(teacherId);
		return new ResponseEntity<Teachers>(teacherService.updateRecord(teacherId, teachers),HttpStatus.ACCEPTED);
		
	}

}
