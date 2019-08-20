package com.trimai.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.countries.models.Country;
import com.trimai.countries.repositories.CityRepo;
import com.trimai.countries.repositories.CountryRepo;
import com.trimai.countries.repositories.LanguageRepo;

@Service
public class ApiService {
	@Autowired
	private CityRepo cityR;
	@Autowired
	private CountryRepo countryR;
	@Autowired
	private LanguageRepo languageR;
	
	public List<Object[]> firstTask(String language) {
		return countryR.joinCountryAndLanguage(language);
	}
	
	public List<Object[]> secondTask() {
		return countryR.displayTotalCitites();
	}
	
	public List<Object[]> thirdTask() {
		return countryR.getMexicoCities("Mexico", 500000);
	}
	
	public List<Object[]> fourthTask() {
		return countryR.getLanguage89(89.00);
	}
	
	public List<Object[]> fifthTask() {
		return countryR.getSurfaceAreaAndPopulation();
	}
	
	public List<Object[]> sixTask() {
		return countryR.sixTask("Constitutional Monarchy");
	}
	
	public List<Object[]> sevenTask() {
		return countryR.sevenTask("Argentina", "Buenos Aires");
	}
	
	public List<Object[]> finalTask() {
		return countryR.finalTask();
	}
}
