package com.amoebiq.ssa.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.model.Teachers;
import com.amoebiq.ssa.repository.BaseTeacherRepository;

@Service
public class TeacherService {
	
	private static final Logger logger = LogManager.getLogger(TeacherService.class);
	
	@Autowired
	private BaseTeacherRepository baseTeacherRepository;
	
	public List<Teachers> findAllTeachers() {
		return baseTeacherRepository.findAll();
	}
	
	public void addTeacher(Teachers teachers) {
		baseTeacherRepository.saveAndFlush(teachers);
	}
	
	public Teachers findATeacher(Long id) {
		return baseTeacherRepository.findOne(id);
	}
	
	public Teachers updateRecord(Long id , Teachers teachers) {
		//Teachers teacher = findATeacher(id);
		baseTeacherRepository.save(teachers);
		return teachers;
	}
	
}
