package com.example.world;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import com.example.world.repository.CountryDocumentRepository;

@SpringBootApplication
public class WorldSpringDataJpaApplication implements ApplicationRunner {
	private final CountryDocumentRepository countryRepository;

	public WorldSpringDataJpaApplication(CountryDocumentRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(WorldSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		countryRepository.findAll(PageRequest.of(2, 20)).forEach(System.out::println);
		var largestCountry = countryRepository.findTopByOrderBySurfaceAreaDesc();
		System.out.println(largestCountry);
	}

}
