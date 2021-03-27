package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	static void displayDate() {
		LOGGER.info("START");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		
		System.out.println("Inside the display date function");
		Date date = new Date("31/12/2018");
		
		SimpleDateFormat sdf = context.getBean("dateFormat" , SimpleDateFormat.class);
		LOGGER.debug(date.toString());
		
		System.out.println(sdf.format(date));
		
		LOGGER.info("END");
	}

	static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("in", Country.class);

		LOGGER.debug("Country : {}", country.toString());
		
		Country anotherCountry = context.getBean("in", Country.class);
		
		LOGGER.debug("Country : {}", anotherCountry.toString());
	}
	
	static void displayCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		ArrayList<Country>  countries= (ArrayList<Country>) context.getBean("countryList");
		
		LOGGER.debug("Country : {}" , countries.toString());
		
	}
	
	public static void main(String[] args) {
		
		LOGGER.info("Inside Main");
		
		SpringApplication.run(SpringLearnApplication.class, args);
		
		displayDate();
		
		displayCountry();
		
		displayCountries();
	}

}
