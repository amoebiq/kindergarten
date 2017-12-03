package com.amoebiq.ssa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amoebiq.ssa.model.Teachers;

public interface BaseTeacherRepository extends JpaRepository<Teachers, Long> {

}
