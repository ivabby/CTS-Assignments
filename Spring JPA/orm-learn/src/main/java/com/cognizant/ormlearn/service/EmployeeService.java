package com.cognizant.ormlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.OrmLearnApplication;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	@Transactional
	public Employee get(int id) {
		LOGGER.info("Start");

		return employeeRepository.findById(id);

	}

	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");

		employeeRepository.save(employee);
		LOGGER.info("End");

	}

	public List<Employee> getAllPermanentEmployees() {
		return employeeRepository.getAllPermanentEmployees();
	}

	public double getAverageSalary() {
		return employeeRepository.getAverageSalary();
	}

	public List<Employee> getAllNativeEmployees() {
		return employeeRepository.getAllEmployeesNative();
	}
}
