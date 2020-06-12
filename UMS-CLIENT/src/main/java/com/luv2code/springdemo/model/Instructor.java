package com.luv2code.springdemo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Instructor {
	
	
	private int id;
	
	@NotNull(message="is Required")
	@Size(min=3, message="Minumum 3 characters required")
	private String firstName;
	
	private String lastName;
	
	@Pattern(regexp="^(.+)@(.+)$", message="Email address must have @ character")
	private String email;
	

	public Instructor()
	{
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}