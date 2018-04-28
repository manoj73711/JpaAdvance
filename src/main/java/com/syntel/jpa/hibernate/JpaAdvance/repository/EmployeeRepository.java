package com.syntel.jpa.hibernate.JpaAdvance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syntel.jpa.hibernate.JpaAdvance.entity.Employee;
import com.syntel.jpa.hibernate.JpaAdvance.entity.FullTimEmployee;
import com.syntel.jpa.hibernate.JpaAdvance.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;

	//insert an employee
	
	public void insert(Employee employee) {
		em.persist(employee);
		
	}
	//retrieve an employee
	public List<Employee>retrieveAllEmployees() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	public List<PartTimeEmployee>retrieveAllPartEmployees() {
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	public List<FullTimEmployee>retrieveAllFullTimeEmployees() {
		return em.createQuery("select e from FullTimEmployee e", FullTimEmployee.class).getResultList();
	}
}
