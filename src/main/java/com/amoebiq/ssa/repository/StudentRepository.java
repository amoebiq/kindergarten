package com.amoebiq.ssa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amoebiq.ssa.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@EntityGraph(value="noJoins",type=EntityGraphType.FETCH)
	@Query(value="From Student s where s.studentId=?1")
	public Student findById(Long id);
	
	
	@Override
    public List<Student> findAll();
	
	@EntityGraph(value="noJoins",type=EntityGraphType.FETCH)
	@Query("from Student s")
	public List<Student> findStudentsOnly();
	

}
