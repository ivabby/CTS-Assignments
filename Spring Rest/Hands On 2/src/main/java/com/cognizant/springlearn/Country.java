package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	private String code;
	private String name;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public Country() {
		LOGGER.debug("Inside Country Constructor");
	}

	public String getCode() {
		LOGGER.debug("Inside getCode method: "+code);
		return code;
	}

	public void setCode(String code) {
		LOGGER.debug("Inside setCode method: "+code);
		this.code = code;
	}

	public String getName() {
		LOGGER.debug("Inside getName method: "+name);
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Inside setName method: "+name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
}
