package com.syntel.jpa.hibernate.JpaAdvance.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="course")
//@NamedQuery(name="query_get_all_courses",query="select c from Course c")
//For the list of named queries 
@NamedQueries(value= {
		@NamedQuery(name="query_get_all_courses",query="select c from Course c")
}

		)
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@UpdateTimestamp
	@Column(name="created_date")
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	@Column(name="last_updated_date")
	private LocalDateTime createdDate;

	public Course() {
		
	}

	public Course(String name) {
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
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
