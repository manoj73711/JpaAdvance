package com.syntel.jpa.hibernate.JpaAdvance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.syntel.jpa.hibernate.JpaAdvance.entity.Course;
import com.syntel.jpa.hibernate.JpaAdvance.entity.FullTimEmployee;
import com.syntel.jpa.hibernate.JpaAdvance.entity.PartTimeEmployee;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Review;
import com.syntel.jpa.hibernate.JpaAdvance.entity.Student;
import com.syntel.jpa.hibernate.JpaAdvance.repository.CourseRepository;
import com.syntel.jpa.hibernate.JpaAdvance.repository.EmployeeRepository;
import com.syntel.jpa.hibernate.JpaAdvance.repository.StudentRepository;

@SpringBootApplication
public class JpaAdvanceApplication implements CommandLineRunner {
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	public CourseRepository courserepository;
	
	@Autowired
	public StudentRepository studentrepository;
	
	@Autowired
	public EmployeeRepository  employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaAdvanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*This is run 7
		 * employeeRepository.insert(new FullTimEmployee("jack", new BigDecimal("10000")));
		employeeRepository.insert(new PartTimeEmployee("jill", new BigDecimal("50")));
		*/	
		
		//Below line is run 6
		//logger.info("All Employess -> {}",employeeRepository.retrieveAllEmployees());
		
		
		/*// run5 Use the below two lines when the MappedSuperClass is uncommented in the Employee Pojo
		logger.info("All PartTimeEmployess -> {}",employeeRepository.retrieveAllPartEmployees());
		logger.info("All FullTimeEmployess -> {}",employeeRepository.retrieveAllFullTimeEmployees());*/
		
		//Below is run4
		//studentrepository.insertStudentAndCourse(new Student("Jack"),new Course("Micro services in 100 steps"));
		
		/*
		 *This is a run3
		 List<Review> list=new ArrayList<>();
		list.add(new Review("5","Great Hands-on stuff."));
		list.add(new Review("4","Great Hands-on stuff."));
		
		courserepository.addReviwsForCourse(10003L,list);*/
		
		
		//below is run2
		//studentrepository.saveStudentWithPassport();
		
		/* Below is run 1
		 * Course course=repository.findById(10001L);
		logger.info("Getting data for id 10001 is {}",course);
		//repository.deletebyId(10001L);
		repository.save(new Course("MicorServices"));*/
		
		//repository.playWithEntityManager();
		
		
	}
}
