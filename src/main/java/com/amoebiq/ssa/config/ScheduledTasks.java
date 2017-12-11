package com.amoebiq.ssa.config;


import java.text.SimpleDateFormat;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.amoebiq.ssa.service.ClassInfoService;
import com.amoebiq.ssa.service.StudentService;


@Configuration
@Async
//@EnableScheduling
public class ScheduledTasks {
	
	private final Logger logger = LogManager.getLogger(ScheduledTasks.class);
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassInfoService classInfoService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
	@Bean(destroyMethod = "shutdown")
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(5);
    }
	
	@Scheduled(initialDelay=10000,fixedDelay=10000)
	public void refreshCacheForStudents() {
		logger.info("Refreshing students by thread :::"+Thread.currentThread().getId());
		logger.info("Refreshing students at time ::: "+sdf.format(System.currentTimeMillis()));
		studentService.getAllStudentsForCache();
		
	}
	
	@Scheduled(fixedDelay=10000)
	public void refreshClassesForCache() {
		logger.info("Refreshing classes by thread :::"+Thread.currentThread().getId());
		logger.info("Refreshing classes at time ::: "+sdf.format(System.currentTimeMillis()));
		classInfoService.allClassesCache();
	}
}
