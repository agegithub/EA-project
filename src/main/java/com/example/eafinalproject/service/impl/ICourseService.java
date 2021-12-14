package com.example.eafinalproject.service.impl;
import com.example.eafinalproject.model.Course;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public interface ICourseService {	
	List<Course> getAllCourses();
	Optional<Course> readCourse(String id);
	Course save(Course course);
	void delete(String id);
	List<Course> coursesWithPrerequisite(String id);
	List<Course> findCourseByTitleAndID(String id, String title);
	List<Course> getCoursesWithNoPrerequisite();
}