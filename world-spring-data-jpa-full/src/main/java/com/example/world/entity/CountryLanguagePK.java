package com.example.world.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class CountryLanguagePK implements Serializable {
	@Column(nullable = false)
	private String language;
	@Column(name = "countrycode", nullable = false)
	private String code;

	public CountryLanguagePK() {
	}

	public CountryLanguagePK(String language, String code) {
		this.language = language;
		this.code = code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, language);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryLanguagePK other = (CountryLanguagePK) obj;
		return Objects.equals(code, other.code) && Objects.equals(language, other.language);
	}

	@Override
	public String toString() {
		return "CountryLanguagePK [language=" + language + ", code=" + code + "]";
	}

}
