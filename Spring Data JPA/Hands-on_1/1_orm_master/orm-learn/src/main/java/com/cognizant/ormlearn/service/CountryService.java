package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository cr;
	@Transactional
	public List<String> getAllCountries(){
		return cr.findAll().stream().map(o1->o1.getName()).collect(Collectors.toList());
		
	}
}
