package com.amoebiq.ssa.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.dao.StudentDAO;
import com.amoebiq.ssa.model.Student;
import com.amoebiq.ssa.repository.StudentRepository;

@Service
public class StudentService {

	private static final Logger logger = LogManager.getLogger(StudentService.class);

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Cacheable(value = "cache1")
	public List<Student> getAllStudents() {
		logger.info("Getting value for all students...");
		return studentRepository.findAll();
	}

	public Student getStudent(String studentId) {
		return studentRepository.findOne(studentId);
	}

	public void removeStudent(String student) {
		studentRepository.delete(student);
	}
}
