package com.cognizant.employee;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

	@Transactional
	public ArrayList<Department> getAllDepartments() {
		DepartmentDao departmentDao = new DepartmentDao();
		return departmentDao.getAllDepartments();
	}
}
