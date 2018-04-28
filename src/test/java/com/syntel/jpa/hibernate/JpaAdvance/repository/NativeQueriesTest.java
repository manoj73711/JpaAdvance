package com.syntel.jpa.hibernate.JpaAdvance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

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
public class NativeQueriesTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;

	@Test
	public void nativeQueries_basic() {
		Query query=em.createNativeQuery("select * from course where is_deleted=0",Course.class);
		List list=query.getResultList();
		logger.info("select c form Course c =>{}",list);
	}
	
	@Test
	public void native_queries_positional_parameters() {
		Query query=em.createNativeQuery("select * from course where id=?",Course.class);
		query.setParameter(1, 10001L);
		List list=query.getResultList();
		logger.info("select c form Course c =>{}",list);
	}
	
	@Test
	public void native_queries_named_parameters() {
		Query query=em.createNativeQuery("select * from course where id=:id",Course.class);
		query.setParameter("id", 10001L);
		List list=query.getResultList();
		logger.info("select c form Course c =>{}",list);
	}
	@Test
	@Transactional
	public void native_queries_update() {
		Query query=em.createNativeQuery("update course set name='whatsup' where id=1");
		int noOfRecordsUpdated=query.executeUpdate();
		logger.info("The number of records got updated are :"+noOfRecordsUpdated);
	}
}
