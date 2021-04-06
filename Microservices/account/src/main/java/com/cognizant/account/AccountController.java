package com.cognizant.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	
	@GetMapping("/accounts/{number}")
	public Account getAccountDetail(@PathVariable int number) {
		return new Account(number,"savings",234);
	}
	
}
