package com.amoebiq.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.dao.StudentDAO;
import com.amoebiq.ssa.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}
	
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

}
