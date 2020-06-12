package com.luv2code.springdemo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Course {

	
	private int id;
	
	@NotNull(message="is Required")
	@Size(min=3, message="Minumum 3 characters required")
	private String title;
	
	private Instructor instructor;

	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Course()
	{
		
	}

	public Course(String title) {
		super();
		this.title = title;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}

}