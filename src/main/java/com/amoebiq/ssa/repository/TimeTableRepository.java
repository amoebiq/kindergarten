package com.amoebiq.ssa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amoebiq.ssa.model.TimeTable;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {
	
	
	
}
