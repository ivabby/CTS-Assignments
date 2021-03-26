package com.cognizant.springlearn.cotroller;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	ArrayList<Country> countryList = (ArrayList<Country>) context.getBean("countryList");

	@RequestMapping(value = "/country")
	public ResponseEntity<Object> getCountryIndia() {

		Country country = (Country) context.getBean("in", Country.class);
		return new ResponseEntity<>(country, HttpStatus.OK);
	}

	@GetMapping(value = "/countries")
	public ResponseEntity<Object> getAllCountries() {

		return new ResponseEntity<>(countryList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/countries/{code}")
	public ResponseEntity<Object> getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
		
		for(Country country: countryList) {
			if(country.getCode().equalsIgnoreCase(code)) {
				return new ResponseEntity<>(country , HttpStatus.OK);
			}
		}
		
		throw new CountryNotFoundException();
	}

	
	
}
