package com.syntel.jpa.hibernate.JpaAdvance.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
//@MappedSuperclass
@Entity
/*Uncomment the block for using one table for Employee
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="EmployeeType")
*/
/*This below is each table for each concrete class
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
*/
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Employee {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;
	public Employee() {

	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
