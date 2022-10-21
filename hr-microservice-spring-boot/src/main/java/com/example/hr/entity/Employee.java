package com.example.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employees")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "identity")
@ToString(exclude = "photo")
public class Employee {
	@Id
	private String identity;
	private String fullname;
	private double salary;
	@Enumerated(EnumType.ORDINAL)
	private FiatCurrency currency;
	private String iban;
	@Enumerated(EnumType.STRING)
	private Department department;
	private JobStyle jobStyle;
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] photo;
}
