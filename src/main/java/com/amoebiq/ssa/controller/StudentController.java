package com.amoebiq.ssa.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amoebiq.ssa.model.Student;
import com.amoebiq.ssa.service.StudentService;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

	private static final Logger logger = LogManager.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
	//@CacheEvict(value="cache1",allEntries=true)
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents() throws InterruptedException {
		logger.info("in get all students");
		return new ResponseEntity<List<Student>>(studentService.allStudentsWithoutJoins(), HttpStatus.OK);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentDetails(@PathVariable("id") long studentId) {

		logger.info("in get student details");
		return new ResponseEntity<Student>(studentService.getStudent(studentId), HttpStatus.OK);

	}

	@PostMapping("new")
	public ResponseEntity<Student> addStudent(@RequestBody Student student, UriComponentsBuilder uriComponents) {

		logger.info("New Student to be added :::" + student.getFirstName());

		// HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(uriComponents.path("/student/{id}").buildAndExpand(student.getStudentId()).toUri());

		return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);

	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> removeStudent(@PathVariable("id") long studentId) {
		logger.info("Student deletion :::: " + studentId);
		studentService.removeStudent(studentId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
