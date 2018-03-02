package com.syntel.jpa.hibernate.JpaAdvance.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syntel.jpa.hibernate.JpaAdvance.entity.Course;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Passport;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student student) {
		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}

	public void deletebyId(Long id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public void saveStudentWithPassport(){
		Passport passport=new Passport("8AP89J");
		em.persist(passport);
		Student student =new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
				
	}
	public void someOperationToUnderstandPersitentContext() {
		//Database operation 1 - Retrive student
		Student student=em.find(Student.class, 20001L);
		
		//Database Operation 2 - Retreive passport
		Passport passport=student.getPassport();
		
		//Database operation 3 - Update passport
		passport.setNumber("L6704585");
		
		//Database operation 4 - update student
		student.setName("Nielsen Dan");	
		
	}

	
	public void insertHardCodedStudentAndCourse() {
		Student student =new Student("Jack");
		Course course=new Course("MicroServices in 100 steps");
		em.persist(student);
		em.persist(course);
		student.addCourse(course);
		course.addStudent(student);
		em.persist(student);
	}
	
	
	public void insertStudentAndCourse(Student student, Course course) {
		
		em.persist(student);
		em.persist(course);
		student.addCourse(course);
		course.addStudent(student);
		em.persist(student);
	}

}
