package com.cognizant.employee;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeDao {
	
	static ArrayList<Employee> EMPLOYEE_LIST;
	
	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
	}
	
	public ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}
}
