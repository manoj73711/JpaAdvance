package com.syntel.jpa.hibernate.JpaAdvance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.syntel.jpa.hibernate.JpaAdvance.JpaAdvanceApplication;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Course;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaAdvanceApplication.class)
public class CriteriaTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;

	@Test
	public void criteria_basic_all_courses() {
		//Select c from Course c"
		//1. Use criteria builder to build a criteria query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for the tables which are involved in the querry
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define predicates etc using the criteria builder
		
		//4. Add predicates etc to the criteria querry
		
		//5. Build the TypedQuerry using the entity manager and criterian querry
		
		TypedQuery<Course> query=em.createQuery(cq.select(courseRoot));
		List list=query.getResultList();
		logger.info("Typed Querry ->{}",list);
	}
	
	@Test
	public void all_courses_having_100Steps() {
		//Select c from Course c where name like '%100 Steps'"
		//1. Use criteria builder to build a criteria query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for the tables which are involved in the querry
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define predicates etc using the criteria builder
		Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");
	
		//4. Add predicates etc to the criteria querry
		cq.where(like100Steps);
		
		//5. Build the TypedQuerry using the entity manager and criterian querry
		
		TypedQuery<Course> query=em.createQuery(cq.select(courseRoot));
		List list=query.getResultList();
		logger.info("all_courses_having_100Steps ->{}",list);
	}
	@Test
	public void all_courses_without_students() {
	// Select c from Course c where c.students is empty
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		
		Root<Course> courseRoot = cq.from(Course.class);
		
		Predicate isempty = cb.isEmpty(courseRoot.get("students"));
	
		cq.where(isempty);
		
		
		TypedQuery<Course> query=em.createQuery(cq.select(courseRoot));
		List list=query.getResultList();
		logger.info("all_courses_without_students ->{}",list);
	}
	
	@Test
	public void join() {
	// Select c from Course c join c.students s
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		
		Root<Course> courseRoot = cq.from(Course.class);
		courseRoot.join("students");
		
		TypedQuery<Course> query=em.createQuery(cq.select(courseRoot));
		List list=query.getResultList();
		logger.info("join ->{}",list);
	}
	@Test
	public void left_join() {
	// Select c from Course c join c.students s
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		
		Root<Course> courseRoot = cq.from(Course.class);
		Join <Object, Object> join=courseRoot.join("students",JoinType.LEFT);
		
		TypedQuery<Course> query=em.createQuery(cq.select(courseRoot));
		List list=query.getResultList();
		logger.info("left_join ->{}",list);
	}

	
}
