package com.amoebiq.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.model.Subject;
import com.amoebiq.ssa.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public Subject newSubject(Subject subject) {
		
		subject.setActive(true);
		return subjectRepository.save(subject);
	}
	
	public List<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}
	
	public String invalidateSubject(Long id) {
		subjectRepository.inavlidateSubject(id);
		return "success";
	}

}
