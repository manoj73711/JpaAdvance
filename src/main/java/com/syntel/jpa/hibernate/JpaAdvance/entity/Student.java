package com.syntel.jpa.hibernate.JpaAdvance.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;

	@ManyToMany
	//joinColumn - STUDENT_ID
	//inverseJoinColumn - COURSE_ID
	@JoinTable(name="STUDENT_COURSE" ,
	joinColumns=@JoinColumn(name="STUDENT_ID"),
	inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	//joinColumn - STUDENT_ID
	//inverseJoinColumn - COURSE_ID
	private List<Course> courses = new ArrayList<>();

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void removeCourse(Course course) {
		courses.remove(course);
	}

	public Student() {

	}

	public Student(String name) {
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
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
