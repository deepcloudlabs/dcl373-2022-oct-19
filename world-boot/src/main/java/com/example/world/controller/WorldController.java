package com.example.world.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.world.aspect.Profiler;
import com.example.world.dao.CityDao;
import com.example.world.dao.CountryDao;
import com.example.world.dao.WorldDao;
import com.example.world.domain.Country;

@RestController
@CrossOrigin
public class WorldController {
	private final WorldDao worldDao;
	private final CityDao cityDao;
	private final CountryDao countryDao;
	
	public WorldController(WorldDao worldDao, CityDao cityDao, CountryDao countryDao) {
		this.worldDao = worldDao;
		this.cityDao = cityDao;
		this.countryDao = countryDao;
		System.out.println(this.worldDao.getClass().getName());
		System.out.println(this.cityDao.getClass().getName());
		System.out.println(this.worldDao.getClass().getName());
	}

	// http://localhost:8200/world/api/v1/continents
	@GetMapping(value="/continents")
	public Set<String> getContinents(){
		return countryDao.getAllContinents();
	}
	
	// http://localhost:8200/world/api/v1/countries?continent=Asia
	@GetMapping(value="/countries",params = "continent")
	@Profiler
	public List<Country> getAllCountriesByContinent(
			@RequestParam String continent){
		return worldDao.findCountriesByContinent(continent);
	}
}
