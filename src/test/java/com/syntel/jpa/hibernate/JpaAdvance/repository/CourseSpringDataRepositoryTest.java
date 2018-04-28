package com.syntel.jpa.hibernate.JpaAdvance.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import com.syntel.jpa.hibernate.JpaAdvance.JpaAdvanceApplication;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaAdvanceApplication.class)
public class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository repository;
	
	@Test
	public void findById_present() {
		Optional<Course> courseOptional = repository.findById(10001L);
		assertTrue(courseOptional.isPresent());
		
	}
		
	@Test
	public void findById_not_present() {
		Optional<Course> courseOptional = repository.findById(200000L);
		assertFalse(courseOptional.isPresent());	
	}
	@Test
	public void saveOrUpdate() {
		Course course = new Course("Spring data in 100 steps");
		repository.save(course);
		course.setName("Spring data JPA in 10 steps");
		repository.save(course);
		Optional<Course> courseOptional = repository.findById(1L);
		assertTrue(courseOptional.isPresent());
	}

	@Test
	public void findall() {
		List<Course> courseOptional = repository.findAll();
		logger.info("list of all courses =>{}",courseOptional);
		logger.info("count of all courses=>{}",repository.count());
	}
	@Test
	public void sortedCourses() {
		Sort sort =new Sort(Sort.Direction.DESC, "name");
		List<Course> courseOptional = repository.findAll(sort);
		logger.info("list of sorted courses => {}",courseOptional);
	}
	@Test
	public void pagination() {
		PageRequest pageRequest=PageRequest.of(0, 3);
		Page<Course> firstPage = repository.findAll(pageRequest);
		logger.info("firstPage results => {}",firstPage.getContent());
		Pageable secondPage = pageRequest.next();
		logger.info("secondPage results => {}",secondPage);
	}
	@Test
	public void findUsingName() {
		logger.info("findUsingName => {}",repository.findByName("Dummy4"));
	}
}
