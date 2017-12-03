package com.amoebiq.ssa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amoebiq.ssa.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>{
	

}
