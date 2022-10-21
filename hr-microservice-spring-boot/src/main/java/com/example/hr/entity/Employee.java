package com.example.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	@Pattern(regexp = "^\\d{11}$")
	private String identity;
	@NotEmpty
	@Size(min = 5)
	private String fullname;
	@Min(3000)
	private double salary;
	@Enumerated(EnumType.ORDINAL)
	private FiatCurrency currency;
	private String iban;
	@Enumerated(EnumType.STRING)
	@NotEmpty
	private Department department;
	@NotEmpty
	private JobStyle jobStyle;
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] photo;
}
