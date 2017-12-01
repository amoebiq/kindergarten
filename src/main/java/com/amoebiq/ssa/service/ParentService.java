package com.amoebiq.ssa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.ssa.dao.ParentDAO;
import com.amoebiq.ssa.model.Parents;

@Service
public class ParentService {
	
	@Autowired
	private ParentDAO parentDAO;
	
	public void addParent(Parents parents) {
		parentDAO.addParent(parents);
	}

}
