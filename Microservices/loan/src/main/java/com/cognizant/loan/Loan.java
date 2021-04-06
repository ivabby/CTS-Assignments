package com.cognizant.loan;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Loan {
	private String number;
	private String type;
	private double loan;
	private double emi;
	private int tenure;
}
