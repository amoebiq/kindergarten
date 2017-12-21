package com.amoebiq.ssa.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.ssa.model.TimeTable;
import com.amoebiq.ssa.service.TimeTableService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/timetable")
public class TimeTableController {
	
	@Autowired
	private TimeTableService timeTableService;
	
	private static final Logger logger = Logger.getLogger(TimeTableController.class);
	
	@RequestMapping(path="/new",method=POST)
	public ResponseEntity<TimeTable> addNewTimeTable(@RequestBody TimeTable timeTable) {
		return new ResponseEntity<TimeTable>(timeTableService.addNewTimeTable(timeTable),HttpStatus.ACCEPTED);
		
	}

}
