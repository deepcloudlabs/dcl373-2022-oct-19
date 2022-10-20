package com.example.world;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.world.dao.WorldDao;


@SpringBootApplication
public class WorldBootApplication implements ApplicationRunner{
	// @Autowired // 1. Field Injection
	// @Inject // CDI
	private WorldDao worldDao;
	
	// 2. Constructor Injection
//	public WorldBootApplication(WorldDao worldDao) {
//		this.worldDao = worldDao;
//	}
	
    // 3. Setter Injection
	@Inject // @Autowired
	public void setWorldDao(WorldDao worldDao) {
		this.worldDao = worldDao;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WorldBootApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		worldDao.findCountriesByContinent("Europe")
		        .forEach(System.out::println);
	}

}
