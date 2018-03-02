package com.syntel.jpa.hibernate.JpaAdvance.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import com.syntel.jpa.hibernate.JpaAdvance.JpaAdvanceApplication;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Course;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Review;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaAdvanceApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;

	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
	}

	@Test
	@DirtiesContext
	public void deletebyId_basic() {
		repository.deletebyId(10001L);
		assertNull(repository.findById(10001L));
	}

	@Test
	@DirtiesContext
	public void save_basic() {
		// get the course
		Course course = repository.findById(10001L);

		// update the course
		course.setName("JPA in 1000 steps");
		
		// check for update functionality
		Course course2 = repository.save(course);
		assertEquals("JPA in 1000 steps", course2.getName());

		// check for the save functionality
		Course course1 = repository.save(new Course("TestCourse"));
		assertEquals("TestCourse", course1.getName());
	}
	@Test
	@DirtiesContext
	public void playWithEntityManager_basic() {
		
	}
	@Test
	//@Transactional
	public void retrieveReviewsForCourse() {
		Course course=repository.findById(10001L);
		logger.info("{}",course.getReviews());
		}
	@Test
	public void retrieveCourseForreview() {
		Review review=em.find(Review.class,50001L);
		logger.info("{}",review.getCourse());
		
	}
	
}
