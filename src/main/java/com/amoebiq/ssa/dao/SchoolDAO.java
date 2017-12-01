package com.amoebiq.ssa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.amoebiq.ssa.model.School;

@Repository
@Transactional
public class SchoolDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<School> getAllSchools() {
		String hql = "FROM School as s order by s.id";
		return (List<School>)entityManager.createQuery(hql).getResultList();
	}
	
	public void addSchool(School school) {
		entityManager.persist(school);
	}
	
	public School getSchool(String id) {
		return entityManager.find(School.class, id);
	}

}
