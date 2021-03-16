package com.cognizant;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	public static void main(String[] args)  {
		ApplicationContext context =SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");
		countryService = context.getBean(CountryService.class);
		testCountries();
	}
	private static void testCountries()  {

		LOGGER.info("Start");
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Menu:\n1-Display All Countries\n2-Display Country with ID");
			System.out.println("3-Delete with Country Code\n4-Update with Country code\n5-Add Country\n6-Display Countries Matches partial code\n7-Exit");
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				List<String> countries = countryService.getAllCountries();
				LOGGER.debug("countries={}", countries);
				break;
			case 2:
				System.out.println("Enter the Country Code");
				String cc=sc.nextLine();
				
				try {
					String c = countryService.getCountryFromCode(cc);
					LOGGER.debug("countries={}", c);
				} catch (CountryNotFoundException e) {
					LOGGER.error(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter the Country Code");
				String cc1=sc.nextLine();
				try {
					countryService.deleteCountry(cc1);
					LOGGER.debug("Country Deleted");
				} catch (CountryNotFoundException e) {
					LOGGER.error(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter the Country Code");
				String cc2=sc.nextLine();
				try {
					countryService.updateCountry(cc2);
					LOGGER.debug("Country Updated");
				} catch (CountryNotFoundException e) {
					LOGGER.error(e.getMessage());
				}
				
				break;
			case 5:
				System.out.println("Enter the Country Code");
				String cc3=sc.nextLine();
				System.out.println("Enter Country Name");
				String cn=sc.nextLine();
				Country c1= new Country();
				c1.setCode(cc3);
				c1.setName(cn);
				countryService.addCoundtry(c1);
				LOGGER.debug("Country Added");
				break;
			case 6:
				System.out.println("Enter the Partial Country Code");
				String cc4=sc.nextLine();
				List<String> c2 = countryService.getCountryMatchPartialName(cc4);
				LOGGER.debug("countries={}", c2);
				break;
			case 7:
				LOGGER.info("ENDING");
				System.exit(0);
			}
		
		}
		}

}
