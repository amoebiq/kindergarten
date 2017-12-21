package com.amoebiq.ssa.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.model.TimeTable;
import com.amoebiq.ssa.repository.TimeTableRepository;

@Service
public class TimeTableService {

	@Autowired
	private TimeTableRepository timeTableRepository;

	private static final Logger logger = Logger.getLogger(TimeTableService.class);

	public TimeTable addNewTimeTable(TimeTable timeTable) {
		logger.info("Adding new time table...");
		return timeTableRepository.save(timeTable);
	}

}
