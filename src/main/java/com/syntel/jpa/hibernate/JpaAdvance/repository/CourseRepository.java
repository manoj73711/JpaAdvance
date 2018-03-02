package com.syntel.jpa.hibernate.JpaAdvance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Course;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Review;

@Repository
@Transactional
public class CourseRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public Course save(Course course) {
		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}

	public void deletebyId(Long id) {
		Course course = findById(id);
		em.remove(course);
	}

	public void playWithEntityManager() {
		Course course1 = new Course("Hello Maple");
		em.persist(course1);

		Course course2 = findById(10001L);
		course2.setName("JPA in 50 Steps");

	}

	public void addHardCodedReviews() {
		// get the course 10003
		Course course = findById(10003L);
		logger.info("course.getReviews() -> {}", course.getReviews());

		// add 2 reviews to it
		Review review1 = new Review("5", "Hands on stuff.");
		Review review2 = new Review("5", "Hats-off");

		// setting the relationship
		course.addReview(review1);
		review1.setCourse(course);
		course.addReview(review2);
		review2.setCourse(course);

		// save it to the database

		em.persist(review1);
		em.persist(review2);
		em.flush();
		//em.clear();
		logger.info("course.getReviews() -> {}", course.getReviews());
	}

	public void addReviwsForCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		logger.info("course.getReviews() -> {}", course.getReviews());

		for (Review review : reviews) {
			// setting the relationship
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
		logger.info("course.getReviews() -> {}", course.getReviews());

	}
	

}
