package com.example.world.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.world.document.CountryDocument;

public interface CountryDocumentRepository extends MongoRepository<CountryDocument, String> {

	CountryDocument findTopByOrderBySurfaceAreaDesc();

	List<CountryDocument> findAllBySurfaceAreaBetween(double from, double to);

	List<CountryDocument> findAllBySurfaceAreaBetweenAndPopulationBetween(double fromArea, double toArea,
			int fromPopulation, int toPopulation);
}
