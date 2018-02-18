package com.syntel.jpa.hibernate.JpaAdvance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.syntel.jpa.hibernate.JpaAdvance.entity.Course;
import com.syntel.jpa.hibernate.JpaAdvance.repository.CourseRepository;

@SpringBootApplication
public class JpaAdvanceApplication implements CommandLineRunner {
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	public CourseRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(JpaAdvanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Course course=repository.findById(10001L);
		logger.info("Getting data for id 10001 is {}",course);
		//repository.deletebyId(10001L);
		repository.save(new Course("MicorServices"));*/
		
		repository.playWithEntityManager();
		
		
	}
}
