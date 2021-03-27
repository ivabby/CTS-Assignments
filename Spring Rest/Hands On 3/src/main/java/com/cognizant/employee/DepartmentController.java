package com.cognizant.employee;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

	@GetMapping(value = "/departments")
	public ResponseEntity<Object> getAllDepartments() {
		ArrayList<Department> departments = new DepartmentService().getAllDepartments();
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}
}
