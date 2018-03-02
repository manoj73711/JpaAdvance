package com.syntel.jpa.hibernate.JpaAdvance.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "course")
// @NamedQuery(name="query_get_all_courses",query="select c from Course c")
// For the list of named queries
@NamedQueries(value = { @NamedQuery(name = "query_get_all_courses", query = "select c from Course c") }

)
public class Course {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@UpdateTimestamp
	@Column(name = "created_date")
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	@Column(name = "last_updated_date")
	private LocalDateTime createdDate;

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private List<Review> reviews=new ArrayList<>();

	@ManyToMany(mappedBy="courses")
	private List<Student> students=new ArrayList<>();

	
	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		students.add(student);
	}
	public void removeStudent(Student student) {
		students.remove(student);
	}
	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		reviews.add(review);
	}

	public void removeReview(Review review) {
		reviews.remove(review);
	}
	/*
	 * public void setReviews(List<Review> reviews) { this.reviews = reviews; }
	 */

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
