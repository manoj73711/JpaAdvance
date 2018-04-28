package com.syntel.jpa.hibernate.JpaAdvance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
public class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;

	@Test
	public void jpql_basic() {
		Query query=em.createNamedQuery("query_get_all_courses");
		List list=query.getResultList();
		logger.info("select c form Course c =>{}",list);
	}
	@Test
	public void jpql_typedQuerry() {
		TypedQuery<Course> query=em.createNamedQuery("query_get_all_courses",Course.class);
		List list=query.getResultList();
		logger.info("select c form Course c =>{}",list);
	}
	
	@Test
	public void jpql_courses_without_students() {
		TypedQuery<Course> querry=em.createQuery("select c from Course c where c.students is empty ", Course.class);
		
		List<Course> list = querry.getResultList();
		logger.info("courses without students ->{}",list);
		
	}
	@Test
	public void jpql_courses_withatleast_2_students() {
		TypedQuery<Course> querry=em.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> list = querry.getResultList();
		logger.info("courses with_atleast_2_students ->{}",list);
	}

		
	@Test
	public void jpql_courses_ordered_by_students() {
		TypedQuery<Course> querry=em.createQuery("select c from Course c order by size(c.students) desc", Course.class);
		List<Course> list = querry.getResultList();
		logger.info("courses jpql_courses_ordered_by_students ->{}",list);
	}

	@Test
	public void jpql_students_with_passports_in_a_certain_pattern() {
		TypedQuery<Student> querry=em.createQuery("select s from Student s where s.passport.number like '%1234%'",Student.class);
		List<Student> list = querry.getResultList();
		logger.info("jpql_students_with_passports_in_a_certain_pattern '%1234%'->{}",list);
	}
	//JOIN => Select c, s from Course c JOIN c.students s
	//LEFT JOIN => Select c, s from Course c LEFT JOIN c.students s
	//CROSS JOIN => Select c, s from Course c, Student s
	//3 * 4 = 12
	@Test
	public void join() {
		Query querry=em.createQuery("Select c, s from Course c JOIN c.students s");
		List<Object []> list = querry.getResultList();
		logger.info("Results Size -> {}", list.size());
		for (Object[] result : list) {
			logger.info("Course {} Student {}", result[0],result[1]);
		}
	}
	@Test
	public void LeftJoin() {
		Query querry=em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
		List<Object []> list = querry.getResultList();
		logger.info("Results Size -> {}", list.size());
		for (Object[] result : list) {
			logger.info("Course {} Student {}", result[0],result[1]);
		}
	}
	@Test
	public void CrossJoin() {
		Query querry=em.createQuery("Select c, s from Course c, Student s");
		List<Object []> list = querry.getResultList();
		logger.info("Results Size -> {}", list.size());
		for (Object[] result : list) {
			logger.info("Course {} Student {}", result[0],result[1]);
		}
	}

	
}
