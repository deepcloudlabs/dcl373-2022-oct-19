package com.example.world.document;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "countries1")
public class CountryDocument {
	@Id
	private String code;
	@Field(name = "name")
	private String name;
	@Field(name = "population")
	private long population;
	@Field(name = "surfacearea")
	private double surfaceArea;
	@Field(name = "continent")
	private String continent;
	public CountryDocument() {
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public double getSurfaceArea() {
		return surfaceArea;
	}
	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryDocument other = (CountryDocument) obj;
		return Objects.equals(code, other.code);
	}
	@Override
	public String toString() {
		return "CountryDocument [code=" + code + ", name=" + name + ", population=" + population + ", surfaceArea="
				+ surfaceArea + ", continent=" + continent + "]";
	}

}
