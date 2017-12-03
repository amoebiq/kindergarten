package com.amoebiq.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.model.ClassInfo;
import com.amoebiq.ssa.repository.ClassInfoRepository;

@Service
public class ClassInfoService {
	
	@Autowired
	private ClassInfoRepository classInfoRepository;
	
	public List<ClassInfo> allClasses() {
		return classInfoRepository.findAll();
	}
	
	public ClassInfo addClass(ClassInfo classInfo) {
		return classInfoRepository.save(classInfo);
	}
}
