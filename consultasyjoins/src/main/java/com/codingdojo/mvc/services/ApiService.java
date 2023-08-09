package com.codingdojo.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.City;
import com.codingdojo.mvc.repositories.CityRepository;
import com.codingdojo.mvc.repositories.CountryRepository;

@Service
public class ApiService {
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	CityRepository cityRepository;


	public List<Object[]> query1() {
		return countryRepository.query1();
	}
	
	public List<Object[]> query2() {
		return countryRepository.query2();
	}
	
	public List<City> query3() {
		return cityRepository.query3();
	}
	
	public List<Object[]> query4() {
		return countryRepository.query4();
	}
	
	public List<Object[]> query5() {
		return countryRepository.query5();
	}
	
	public List<Object[]> query6() {
		return countryRepository.query6();
	}
	
	public List<Object[]> query7() {
		return countryRepository.query7();
	}
	
	public List<Object[]> query8() {
		return countryRepository.query8();
	}
	
}
