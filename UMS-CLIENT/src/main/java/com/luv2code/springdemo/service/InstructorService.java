package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.model.Course;
import com.luv2code.springdemo.model.Instructor;

public interface InstructorService {

	public List<Instructor> getInstructors();

	public void saveInstructor(Instructor theInstructor);

	public Instructor getInstructor(int theId);

	public void deleteInstructor(int id);

	public List<Course> getInstructorCourses(int id);

	public void deleteInstructorCourse(int courseId);

	public List<Course> listAddInstructorCourse();

	public void addInstructorCourse(int courseId, int instructorId);
	
}