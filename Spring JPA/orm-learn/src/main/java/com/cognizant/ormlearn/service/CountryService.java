package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	
	/**
	 * Fetch all countries from database
	 * @return
	 */
	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	/**
	 * Find a country based on given country code
	 * @param countryCode
	 * @return
	 * @throws CountryNotFoundException
	 */
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException();
		}

		Country country = result.get();
		return country;
	}

	/**
	 * Add a new country in database
	 * @param country
	 */
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
	
	/**
	 * Update a country in database
	 * @param country
	 */
	@Transactional
	public void updateCountry(Country country) {
		countryRepository.save(country);
	}
	
	
	/**
	 * Delete a country based on the id
	 * @param id
	 */
	@Transactional
	public void deleteCountry(String id) {
		countryRepository.deleteById(id);
	}
	
	
	/**
	 * Finding country name based on given pattern
	 * @param pattern
	 * @return
	 */
	public List<Country> findCountries(String pattern) {
		List<Country> countries = countryRepository.findByNameLike(pattern);
		return countries;
	}
}
