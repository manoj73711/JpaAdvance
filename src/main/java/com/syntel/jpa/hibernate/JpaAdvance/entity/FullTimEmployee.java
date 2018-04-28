package com.syntel.jpa.hibernate.JpaAdvance.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class FullTimEmployee extends Employee {
	protected FullTimEmployee() {

	}

	public FullTimEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}
	@Column
	private BigDecimal salary;

	public BigDecimal getsalary() {
		return salary;
	}

	public void setsalary(BigDecimal salary) {
		this.salary = salary;
	}

}
