package com.cognizant.ormlearn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.OrmLearnApplication;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	@Transactional
	public Department get(int id) {
		LOGGER.info("Starting");
		return departmentRepository.findById(id);
	}
	
	@Transactional
	public void save(Department department) {
		LOGGER.info("Start");

		departmentRepository.save(department);
		LOGGER.info("End");
	}
}
