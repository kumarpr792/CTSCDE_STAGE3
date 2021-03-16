package com.cognizant.ormlearn.exception;

public class CountryNotFoundException extends Exception{

	public CountryNotFoundException() {
		super("NO COUNTRY FOUND");
	}
}
