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
import com.luv2code.springdemo.model.Student;

@Service
public class CourseServiceImpl implements CourseService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public CourseServiceImpl(RestTemplate theRestTemplate, 
										@Value("${courses.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Course> getCourses() {
		
		logger.info("in getCourses(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Course>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Course>>() {});

		// get the list of courses from response
		List<Course> courses = responseEntity.getBody();

		logger.info("in getCourses(): courses" + courses);
		
		return courses;
	}

	@Override
	public Course getCourse(int theId) {

		logger.info("in getCourse(): Calling REST API " + crmRestUrl);

		// make REST call
		Course theCourse = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
										  Course.class);

		logger.info("in saveCourse(): theCourse=" + theCourse);
		
		return theCourse;
	}

	@Override
	public void saveCourse(Course theCourse) {

		logger.info("in saveCourse(): Calling REST API " + crmRestUrl);
		
		int courseId = theCourse.getId();

		// make REST call
		if (courseId == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, theCourse, String.class);			
		
		} else {
			// update employee
			restTemplate.put(crmRestUrl, theCourse);
		}

		logger.info("in saveCourse(): success");	
	}

	@Override
	public void deleteCourse(int theId) {

		logger.info("in deleteCourse(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteCourse(): deleted course theId=" + theId);
	}

	@Override
	public List<Student> showStudents(int courseId) {
		
		logger.info("in getCourses(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Student>> responseEntity = 
											restTemplate.exchange(crmRestUrl + "/students/" + courseId, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Student>>() {});

		// get the list of students from response
		List<Student> students = responseEntity.getBody();

		logger.info("in getCourses(): courses" + students);
		
		return students;
	}
	
}