package com.example.world.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.world.dao.WorldDao;
import com.example.world.domain.Country;

@RestController
public class WorldController {
	private final WorldDao worldDao;
	
	public WorldController(WorldDao worldDao) {
		this.worldDao = worldDao;
	}

	// http://localhost:8200/world/api/v1/continents
	@GetMapping(value="/continents")
	public Set<String> getAllContinents(){
		return worldDao.getAllContinents();
	}
	
	// http://localhost:8200/world/api/v1/countries?continent=Asia
	@GetMapping(value="/countries",params = "continent")
	public List<Country> getAllCountriesByContinent(
			@RequestParam String continent){
		return worldDao.findCountriesByContinent(continent);
	}
}
