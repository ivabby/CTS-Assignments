package com.cognizant.springlearn.cotroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	ArrayList<Country> countryList = (ArrayList<Country>) context.getBean("countryList");

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@GetMapping(value = "/countries")
	public ResponseEntity<Object> getAllCountries() {

		return new ResponseEntity<>(countryList, HttpStatus.OK);
	}

	@GetMapping(value = "/countries/{code}")
	public ResponseEntity<Object> getCountry(@PathVariable("code") String code) throws CountryNotFoundException {

		for (Country country : countryList) {
			if (country.getCode().equalsIgnoreCase(code)) {
				return new ResponseEntity<>(country, HttpStatus.OK);
			}
		}

		throw new CountryNotFoundException();
	}

	@PostMapping(value = "/countries")
	public void addCountry(@RequestBody @Valid Country country) {
		LOGGER.debug("Started {}", country);
		
		countryList.add(country);
		LOGGER.debug("Country Added");
		LOGGER.debug("END");

	}

}
