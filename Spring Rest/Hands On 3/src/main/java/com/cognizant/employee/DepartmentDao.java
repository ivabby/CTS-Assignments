package com.cognizant.employee;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DepartmentDao {
	static ArrayList<Department> DEPARTMENT_LIST;
	
	public DepartmentDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList");
	}
	
	public ArrayList<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}
	
}
