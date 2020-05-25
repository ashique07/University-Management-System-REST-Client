package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.model.Course;
import com.luv2code.springdemo.model.Student;

public interface CourseService {

	public List<Course> getCourses();

	public void saveCourse(Course theCourse);

	public Course getCourse(int theId);

	public void deleteCourse(int id);

	public List<Student> showStudents(int courseId);
	
}