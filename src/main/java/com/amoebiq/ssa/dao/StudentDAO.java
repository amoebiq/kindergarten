package com.amoebiq.ssa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.amoebiq.ssa.model.Parents;
import com.amoebiq.ssa.model.Student;

@Repository
@Transactional
public class StudentDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void addStudent(Student student) {
		entityManager.persist(student);
		
	}
	
	public List<Student> getAllStudents() {
		String hql = "FROM Student as s order by s.studentId";
		return (List<Student>) entityManager.createQuery(hql).getResultList();
	}
	
	public Student getStudent(String studentId) {
		return entityManager.find(Student.class, studentId);
	}
	
	public void removeStudent(String student) {
		entityManager.remove(getStudent(student));
	}
	
}
