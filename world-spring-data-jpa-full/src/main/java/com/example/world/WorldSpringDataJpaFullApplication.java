package com.example.world;

import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import com.example.world.repository.CountryRepository;

@SpringBootApplication
public class WorldSpringDataJpaFullApplication implements ApplicationRunner{
	private final CountryRepository countryRepository;
	
	public WorldSpringDataJpaFullApplication(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(WorldSpringDataJpaFullApplication.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		countryRepository.findAll(PageRequest.of(0, 20))
		                 .forEach(System.out::println);
		
	}

}
