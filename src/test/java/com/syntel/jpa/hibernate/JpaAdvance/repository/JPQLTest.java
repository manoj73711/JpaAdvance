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

	
}
