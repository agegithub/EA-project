package com.example.eafinalproject.service;

import com.example.eafinalproject.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}