package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.model.Course;
import com.luv2code.springdemo.model.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int theId);

	public void deleteStudent(int id);

	public List<Course> getStudentCourses(int id);

	public void deleteStudentCourse(int courseId, int studentId);

	public List<Course> listAddStudentCourse(int studentId);

	public void addStudentCourse(int courseId, int studentId);
	
}