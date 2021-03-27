package com.cognizant.employee;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

	@Transactional
	public ArrayList<Employee> getAllEmployees() {
		EmployeeDao employeeDao = new EmployeeDao();
		return employeeDao.getAllEmployees();
	}

}
