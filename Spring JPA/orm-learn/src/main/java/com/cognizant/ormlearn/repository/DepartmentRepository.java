package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
	
	@Query("select c from Department c where dp_id = ?1")
	Department findById(int id);
}
