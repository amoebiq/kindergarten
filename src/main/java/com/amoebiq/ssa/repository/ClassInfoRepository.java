package com.amoebiq.ssa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amoebiq.ssa.model.ClassInfo;

public interface ClassInfoRepository extends JpaRepository<ClassInfo, Long> {

}
