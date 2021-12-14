package com.example.eafinalproject.repository;
import com.example.eafinalproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

	@Query(value = "select * from Course c  where c.prerequisite_id = ?1", nativeQuery = true)
	List<Course> coursesWithPrerequisite(String id);
		
	@Query(value = "select * from Course c  where c.id = ?1 and c.title = ?2", nativeQuery = true)
	List<Course> findCourseByTitleAndID(String id, String name);
	
	@Query(value = "update Course c set c.name = ?1, c.courseId = ?2, c.prerequisite = ?3 where c.id = ?4")
	public void update(@Param("title") String title
			, @Param("courseId") int courseId, @Param("prerequisite") Course prerequisite, @Param("id") Long id);
	
	@Query(value = "select * from Course c  where c.prerequisite_id = NULL", nativeQuery = true)
	List<Course> getCoursesWithNoPrerequisite();

	 @Query(value = "select * from Course c where c.title = ?1", nativeQuery = true)
	public Course findCourseByTitle(String courseName);

}