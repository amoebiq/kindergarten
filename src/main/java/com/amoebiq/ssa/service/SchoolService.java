package com.amoebiq.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.dao.SchoolDAO;
import com.amoebiq.ssa.model.School;

@Service
public class SchoolService {

	@Autowired
	private SchoolDAO schoolDAO;

	public List<School> getAllSchools() {

		return schoolDAO.getAllSchools();
	}

	public void addSchool(School school) {
		schoolDAO.addSchool(school);
	}

	public School getSchool(String id) {
		return schoolDAO.getSchool(id);
	}

}
