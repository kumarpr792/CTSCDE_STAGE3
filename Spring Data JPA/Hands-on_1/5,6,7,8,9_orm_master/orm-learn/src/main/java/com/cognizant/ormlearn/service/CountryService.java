package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService implements CountrySevIn{

	Scanner sc=new Scanner(System.in);
	@Autowired
	private CountryRepository cr;
	@Transactional
	@Override
	public List<String> getAllCountries(){
		return cr.findAll().stream().map(o1->o1.getName()).collect(Collectors.toList());
		
	}
	@Transactional
	@Override
	public String getCountryFromCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> c= cr.findById(countryCode);
		if(!c.isPresent())
			throw new CountryNotFoundException();
		Country con=c.get();
		return con.getName();
	}
	@Transactional
	@Override
	public void addCoundtry(Country country) {
		cr.save(country);
		
	}
	@Transactional
	@Override
	public void deleteCountry(String countryCode) throws CountryNotFoundException {
		Optional<Country> c= cr.findById(countryCode);
		if(!c.isPresent())
			throw new CountryNotFoundException();
		cr.deleteById(countryCode);
	}
	@Transactional
	@Override
	public void updateCountry(String countryCode) throws CountryNotFoundException {
		Optional<Country> c= cr.findById(countryCode);
		if(!c.isPresent())
			throw new CountryNotFoundException();
		Country con=c.get();
		System.out.println("Enter the Country Name");
		con.setName(sc.nextLine());
		cr.save(con);
	}
	@Transactional
	@Override
	public List<String> getCountryMatchPartialName(String countryCode) {
		List<String> l=cr.findAll().stream().map(o1->o1.getCode()).collect(Collectors.toList());
		//String pa="."+countryCode+"|"+countryCode+".";
		return l.stream().filter(o->o.matches("."+countryCode+"|"+countryCode+".")).collect(Collectors.toList());
	}
}
