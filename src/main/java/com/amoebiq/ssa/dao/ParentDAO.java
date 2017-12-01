package com.amoebiq.ssa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.amoebiq.ssa.model.Parents;

@Repository
@Transactional
public class ParentDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addParent(Parents parent){
		entityManager.persist(parent);
	}
	
}
