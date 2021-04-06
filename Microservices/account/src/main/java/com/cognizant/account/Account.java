package com.cognizant.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
	private int number;
	private String type;
	private double balance;
}
