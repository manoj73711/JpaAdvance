package com.syntel.jpa.hibernate.JpaAdvance.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
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
	
	public void playWithEntityManager(){
		Course course =new Course("Hello Maple");
		em.persist(course);
		course.setName("Hello Maple?? Whats this ?");
	}

}
