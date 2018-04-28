package com.syntel.jpa.hibernate.JpaAdvance.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {
	protected PartTimeEmployee() {

	}

	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
	@Column
	private BigDecimal hourlyWage;

	public BigDecimal getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(BigDecimal hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

}
