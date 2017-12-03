package com.amoebiq.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.dao.StudentDAO;
import com.amoebiq.ssa.model.Student;
import com.amoebiq.ssa.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudent(String studentId) {
		return studentRepository.findOne(studentId);
	}

	public void removeStudent(String student) {
		studentRepository.delete(student);
	}
}
