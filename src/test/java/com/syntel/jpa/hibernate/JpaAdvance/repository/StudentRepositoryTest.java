package com.syntel.jpa.hibernate.JpaAdvance.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.syntel.jpa.hibernate.JpaAdvance.JpaAdvanceApplication;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Passport;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaAdvanceApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	//This below test is to show the early loading and eagerly loading
	@Test
	@Transactional
	public void retrieveStudentAndAssociatedPassport() {
		Student student=em.find(Student.class, 20001L);
		logger.info("Student->{}",student);
		logger.info("Student Passport {}",student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport=em.find(Passport.class, 40001L);
		logger.info("Passport->{}",passport);
		logger.info("Passport Student {}",passport.getStudent());
	}
	
	//session& Session Factory
	//Entity Manager & Persistence Context
	//Transaction
	
	@Test
	@Transactional 
	public void someTest() {
		//Database operation 1 - Retrive student
		Student student=em.find(Student.class, 20001L);
		
		//Database Operation 2 - Retreive passport
		Passport passport=student.getPassport();
		
		//Database operation 3 - Update passport
		passport.setNumber("L6704585");
		
		//Database operation 4 - update student
		student.setName("Nielsen Dan");	
		
	}
	
	// Below block is more on to Student Repository in session1
/* 
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
		
	}*/
}
