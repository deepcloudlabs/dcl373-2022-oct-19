package com.example.world.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.world.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String>{

}
