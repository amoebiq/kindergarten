package com.amoebiq.ssa.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.dao.StudentDAO;
import com.amoebiq.ssa.model.ClassInfo;
import com.amoebiq.ssa.model.Student;
import com.amoebiq.ssa.repository.ClassInfoRepository;
import com.amoebiq.ssa.repository.StudentRepository;

@Service
public class StudentService {

	private static final Logger logger = LogManager.getLogger(StudentService.class);

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassInfoRepository classInfoRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Cacheable(value = "studentCache")
	public List<Student> getAllStudents() throws InterruptedException {
		Thread.sleep(10000);
		logger.info("Getting value for all students...");
		return studentRepository.findAll();
	}
	
	@CachePut(value = "studentCache")
	public List<Student> getAllStudentsForCache() {
		logger.info("Refreshing the cache to get student data...");
		return studentRepository.findAll();
	}

	public Student getStudent(long studentId) {
		return studentRepository.findOne(studentId);
	}

	public void removeStudent(long student) {
		studentRepository.delete(student);
	}
	
	public List<Student> allStudentsWithoutJoins() {
		return studentRepository.findStudentsOnly();
	}
	
	public void addStudentToClass(long classId,long studId) {
		
		ClassInfo classInfo = classInfoRepository.findOne(classId);
		if(classInfo==null) {
			logger.error("No Class found");
			return;
		}
		Student student = studentRepository.findById(studId);
		if(student==null) {
			logger.error("No student found");
			return;
		}
		student.setClassInfo(classInfo);
		studentRepository.save(student);
	}
	
	public List<Student> getStudentsByClass(long classId) {
		return studentRepository.findStudentsByClass(classId);
	}
	
	public List<Student> getStudentsByClassAndGrade(String classNo,String grade) {
		return studentRepository.findStudentsByClassNoAndGrade(classNo, grade);
	}
}
