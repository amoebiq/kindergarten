package com.amoebiq.ssa.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amoebiq.ssa.model.Parents;
import com.amoebiq.ssa.service.ParentService;

@RestController
@RequestMapping(path = "/parents")
public class ParentController {

	private static final Logger logger = LogManager.getLogger(ParentController.class);
	@Autowired
	private ParentService parentService;

	@PostMapping("new")
	public ResponseEntity<Void> addNewParent(@RequestBody Parents parents, UriComponentsBuilder uriComponents) {

		logger.info("New School to be added :::" + parents.getFirstName());
		parentService.addParent(parents);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponents.path("/parent/{id}").buildAndExpand(parents.getParentId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}
}
