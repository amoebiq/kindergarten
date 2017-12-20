package com.amoebiq.ssa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.amoebiq.ssa.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
	
	
	@Query(value="from Subject s where s.active=1")
	public List<Subject> findAll();
	
	@Transactional
	@Modifying
	@Query(value="update Subject s set s.active=0 , s.updatedAt=now() where s.id=?1")
	public void inavlidateSubject(Long id);

}
