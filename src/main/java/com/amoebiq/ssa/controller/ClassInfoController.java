package com.amoebiq.ssa.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.ssa.model.ClassInfo;
import com.amoebiq.ssa.service.ClassInfoService;

@RestController
@RequestMapping(path = "/classes")
public class ClassInfoController {

	private static Logger logger = LogManager.getLogger(ClassInfoController.class);

	@Autowired
	private ClassInfoService classInfoService;

	@GetMapping("all")
	public ResponseEntity<List<ClassInfo>> getAllClasses() {

		logger.info("In all classes...");
		return new ResponseEntity<List<ClassInfo>>(classInfoService.allClasses(), HttpStatus.ACCEPTED);

	}

	@PostMapping("new")
	public ResponseEntity<ClassInfo> newClass(@RequestBody ClassInfo classInfo) {

		logger.info("new Class to be created ::: " + classInfo.getClassNo());
		return new ResponseEntity<ClassInfo>(classInfoService.addClass(classInfo), HttpStatus.CREATED);
	}
}
