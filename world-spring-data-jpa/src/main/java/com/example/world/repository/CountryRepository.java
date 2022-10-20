package com.example.world.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.world.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String>{

	@Query(nativeQuery = true, value="select distinct continent from country")
	Set<String> getAllContinents();

	List<Country> findAllByContinent(String continent);
	
	@Query("select c from Country c where c.population between :from and :to")
	List<Country> findAllByPopulationBetween(int from,int to);
	
	List<Country> findAllBySurfaceAreaBetween(double from,double to);
	List<Country> findAllBySurfaceAreaBetweenAndPopulationBetween(
			double fromArea,double toArea,
			int fromPopulation,int toPopulation);
}
