package com.cognizant.ormlearn;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	// private static CountryService countryService;

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	/*
	 * private static void testGetAllCountries() {
	 * 
	 * LOGGER.info("Start");
	 * 
	 * List<Country> countries = countryService.getAllCountries();
	 * 
	 * LOGGER.debug("countries={}", countries);
	 * 
	 * LOGGER.info("End");
	 * 
	 * }
	 * 
	 * private static void getAllCountriesTest() {
	 * 
	 * LOGGER.info("Start");
	 * 
	 * Country country; try { country = countryService.findCountryByCode("AD");
	 * 
	 * LOGGER.debug("Country:{}", country);
	 * 
	 * LOGGER.info("End"); } catch (CountryNotFoundException e) { // TODO
	 * Auto-generated catch block LOGGER.debug("No country found with given code");
	 * }
	 * 
	 * }
	 * 
	 * private static void testAddCountry() { Country country = new Country();
	 * country.setCode("IN"); country.setName("India");
	 * 
	 * countryService.addCountry(country);
	 * 
	 * try { country = countryService.findCountryByCode("IN");
	 * 
	 * LOGGER.debug("Country:{}", country);
	 * 
	 * LOGGER.info("End"); } catch (CountryNotFoundException e) { // TODO
	 * Auto-generated catch block LOGGER.debug("No country found with given code");
	 * } }
	 * 
	 * private static void testUpdateCountry() { Country country = new Country();
	 * country.setCode("IN"); country.setName("India");
	 * 
	 * LOGGER.info("Updating Country");
	 * 
	 * countryService.updateCountry(country);
	 * 
	 * LOGGER.info("Country Updated"); }
	 * 
	 * private static void testDeleteCountry() { LOGGER.info("Deleting Country");
	 * 
	 * countryService.deleteCountry("IN");
	 * 
	 * LOGGER.info("Country deleted"); }
	 * 
	 * private static void testFindCountries() { String countryName = "a";
	 * 
	 * LOGGER.info("Searching for pattern"); List<Country> countries =
	 * countryService.findCountries(countryName);
	 * LOGGER.info("Searched for pattern");
	 * 
	 * if (countries.isEmpty()) {
	 * LOGGER.info("No country found with given pattern"); } for (Country country :
	 * countries) { LOGGER.info("Country : " + country); } }
	 */

	private static void testGetEmployee() {

		LOGGER.info("Start");

		Employee employee = employeeService.get(1);

		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());

		LOGGER.debug("Skills:{}", employee.getSkillList());

		LOGGER.info("End");

	}

	private static void testAddEmployee() {
		Employee employee = new Employee();
		employee.setName("Arjun");
		employee.setPermanent(false);
		employee.setSalary(20000.23);

		Department department = departmentService.get(1);
		employee.setDepartment(department);
		employee.setDateOfBirth(null);

		employeeService.save(employee);

		LOGGER.debug("Employee:{}", employee);
	}

	private static void testUpdateEmployee() {
		Employee employee = employeeService.get(2);
		Department department = departmentService.get(2);

		employee.setDepartment(department);

		employeeService.save(employee);

		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());
	}

	private static void testGetDepartment() {
		Department department = departmentService.get(1);
		LOGGER.debug("Department:{}", department);

		LOGGER.debug("Employee:{}", department.getEmployeeList());
	}

	private static void testAddSkillToEmployee() {
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(1);

		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);
		employee.setSkillList(skillList);

		employeeService.save(employee);
	}

	public static void testGetAllPermanentEmployees() {

		LOGGER.info("Start");

		List<Employee> employees = employeeService.getAllPermanentEmployees();

		LOGGER.debug("Permanent Employees:{}", employees);

		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));

		LOGGER.info("End");

	}

	private static void testGetAverageSalary() {
		LOGGER.info("Start");

		double avgSalary = employeeService.getAverageSalary();
		LOGGER.debug("Average Salary:" + avgSalary);

		LOGGER.info("END");
	}

	private static void testGetAllNativeEmployees() {
		LOGGER.info("Start");
		
		List<Employee> employeeList = employeeService.getAllNativeEmployees();
		LOGGER.debug("Employee:{}",employeeList);

		LOGGER.info("END");
	}

	public static void main(String[] args) {

		SpringApplication.run(OrmLearnApplication.class, args);

		LOGGER.info("Inside main");

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

//		countryService = context.getBean(CountryService.class);

		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

//		testGetAllCountries();

//		getAllCountriesTest();

//		testAddCountry();

//		testUpdateCountry();

//		testDeleteCountry();

//		testFindCountries();

//		testGetEmployee();

//		testAddEmployee();

//		testUpdateEmployee();

//		testGetDepartment();

//		testAddSkillToEmployee();

//		testGetAllPermanentEmployees();

//		testGetAverageSalary();
		
		testGetAllNativeEmployees();
	}

}
