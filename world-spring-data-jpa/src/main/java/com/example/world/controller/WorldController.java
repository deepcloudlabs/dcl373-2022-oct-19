package com.example.world.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.world.entity.Country;
import com.example.world.repository.CountryRepository;

@RestController
@CrossOrigin
public class WorldController {
	private final CountryRepository countryRepository;
	

	public WorldController(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	// http://localhost:8200/world/api/v1/continents
	@GetMapping(value="/continents")
	public Set<String> getContinents(){
		return countryRepository.getAllContinents();
	}
	
	// http://localhost:8200/world/api/v1/countries?continent=Asia
	@GetMapping(value="/countries",params = "continent")
	public List<Country> getAllCountriesByContinent(
			@RequestParam String continent){
		return countryRepository.findAllByContinent(continent);
	}
}
