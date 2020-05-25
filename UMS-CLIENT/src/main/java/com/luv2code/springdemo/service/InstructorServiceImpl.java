package com.luv2code.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springdemo.model.Course;
import com.luv2code.springdemo.model.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	
	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public InstructorServiceImpl(RestTemplate theRestTemplate, 
										@Value("${instructors.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Instructor> getInstructors() {
		
		logger.info("in getInstructors(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Instructor>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Instructor>>() {});

		// get the list of Instructors from response
		List<Instructor> Instructors = responseEntity.getBody();

		logger.info("in getInstructors(): Instructors" + Instructors);
		
		return Instructors;
	}

	@Override
	public Instructor getInstructor(int theId) {

		logger.info("in getInstructor(): Calling REST API " + crmRestUrl);

		// make REST call
		Instructor theInstructor = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
										  Instructor.class);

		logger.info("in saveInstructor(): theInstructor=" + theInstructor);
		
		return theInstructor;
	}

	@Override
	public void saveInstructor(Instructor theInstructor) {

		logger.info("in saveInstructor(): Calling REST API " + crmRestUrl);
		
		int instructorId = theInstructor.getId();

		// make REST call
		if (instructorId == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, theInstructor, String.class);			
		
		} else {
			// update employee
			restTemplate.put(crmRestUrl, theInstructor);
		}

		logger.info("in saveInstructor(): success");	
	}

	@Override
	public void deleteInstructor(int theId) {

		logger.info("in deleteInstructor(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteInstructor(): deleted Instructor theId=" + theId);
	}

	@Override
	public List<Course> getInstructorCourses(int instructorId) {
		
		logger.info("in getInstructors(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Course>> responseEntity = 
											restTemplate.exchange(crmRestUrl + "/courses/" + instructorId, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Course>>() {});

		// get the list of Instructors from response
		List<Course> courses = responseEntity.getBody();

		logger.info("in getInstructors(): courses" + courses);
		
		return courses;
	}

	@Override
	public void deleteInstructorCourse(int courseId) {
		
		logger.info("in deleteInstructorCourse(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/courses/" + courseId);

		logger.info("in deleteInstructorCourse(): deleted Course theId=" + courseId);
		
		
	}

	@Override
	
	public List<Course> listAddInstructorCourse() {
		
		logger.info("in listAddInstructorCourse(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Course>> responseEntity = 
											restTemplate.exchange(crmRestUrl +"/courses/add", HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Course>>() {});

		// get the list of Instructors from response
		List<Course> courses = responseEntity.getBody();

		logger.info("in listAddInstructorCourses(): Courses" + courses);
		
		return courses;
	}

	@Override
	public void addInstructorCourse(int courseId, int instructorId) {
		
		logger.info("in addInstructorCourse(): Calling REST API " + crmRestUrl);
		
		
		restTemplate.postForEntity(crmRestUrl + "/courses/add/" + courseId + "/" + instructorId, null, null);			
		

		logger.info("in addInstructorCourse(): success");
		
	}
	
}