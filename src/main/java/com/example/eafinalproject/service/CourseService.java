package com.example.eafinalproject.service;
import com.example.eafinalproject.model.Course;
import com.example.eafinalproject.repository.CourseRepository;
import com.example.eafinalproject.service.impl.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class CourseService implements ICourseService {

	@Autowired
	CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		return this.courseRepository.findAll();
	}

	public Optional<Course> readCourse(String id) {return this.courseRepository.findById(id);}

	public Course save(Course course) {
		return this.courseRepository.save(course);
	}

	public void delete(String id) {
		this.courseRepository.findById(id);
	}

	public List<Course> coursesWithPrerequisite(String  id) {
		return this.courseRepository.coursesWithPrerequisite(id);
	}

	public List<Course> findCourseByTitleAndID(String id, String title) {return this.courseRepository.findCourseByTitleAndID(id, title);
	}
	@Override
	public List<Course> getCoursesWithNoPrerequisite() {
		return this.courseRepository.getCoursesWithNoPrerequisite();
	}

}