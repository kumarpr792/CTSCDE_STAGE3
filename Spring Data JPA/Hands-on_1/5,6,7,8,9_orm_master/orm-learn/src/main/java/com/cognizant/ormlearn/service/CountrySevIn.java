package com.cognizant.ormlearn.service;

import java.util.List;

import com.cognizant.ormlearn.model.Country;

public interface CountrySevIn {
	public List<String> getAllCountries();
	public String getCountryFromCode(String countryCode) throws Exception;
	public void addCoundtry(Country country);
	public void deleteCountry(String countryCode) throws Exception;
	public void updateCountry(String countryCode) throws Exception;
	public List<String> getCountryMatchPartialName(String countryCode);
}
