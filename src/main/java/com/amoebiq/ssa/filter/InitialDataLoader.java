package com.amoebiq.ssa.filter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoader  implements ApplicationListener<ContextRefreshedEvent>{
	
	private static final Logger logger = LogManager.getLogger(InitialDataLoader.class);
	
	/*
	 * Used to load the initial user privileges etc at the context start up
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		logger.info("application event recieved");
		
	}
	
	

}
