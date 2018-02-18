

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syntel.jpa.hibernate.JpaAdvance.entity.Course;

@Repository
public class CourseRepository {

	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	/*public save(Course course) {
		
	}
	
	public deletebyId(Long id) {
		
	}
	*/
}
