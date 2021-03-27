package com.cognizant.employee;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	ArrayList<Employee> employees;

	@GetMapping(value = "/employees")
	public ResponseEntity<Object> getAllEmployees() {
		employees = new EmployeeService().getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/employees/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		LOGGER.info("Started Deleting");
		boolean found = false;
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		for(Employee employee: employees) {
			if(employee.getId() == id) {
				found = true;
			} else {
				employeeList.add(employee);
			}
		}
		
		if(found) {
			employees = employeeList;
		} else {
			throw new EmployeeNotFoundException();
		}
		
		LOGGER.info("Employee List {}",employees);
		
	}
}
