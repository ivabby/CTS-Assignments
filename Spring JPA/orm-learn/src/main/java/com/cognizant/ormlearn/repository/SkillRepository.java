package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String> {

	@Query("select c from Skill c where c.id = ?1")
	Skill findById(int id);
}
