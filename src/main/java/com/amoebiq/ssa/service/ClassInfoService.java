package com.amoebiq.ssa.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.model.ClassInfo;
import com.amoebiq.ssa.repository.ClassInfoRepository;

@Service
public class ClassInfoService {
	
	private static final Logger logger = LogManager.getLogger(ClassInfoService.class);
	
	@Autowired
	private ClassInfoRepository classInfoRepository;
	
	@Cacheable("classCache")
	public List<ClassInfo> allClasses() {
		logger.info("Loading all classes from DB...");
		return classInfoRepository.findAll();
	}
	
	@CachePut("classCache")
	public List<ClassInfo> allClassesCache() {
		logger.info("Refreshing the cache to get All Classes...");
		return classInfoRepository.findAll();
	}
	
	public ClassInfo addClass(ClassInfo classInfo) {
		return classInfoRepository.save(classInfo);
	}
}
