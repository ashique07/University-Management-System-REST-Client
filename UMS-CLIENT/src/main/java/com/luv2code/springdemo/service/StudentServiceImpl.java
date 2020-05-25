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
public class StudentServiceImpl implements StudentService {

	
	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public StudentServiceImpl(RestTemplate theRestTemplate, 
										@Value("${students.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Student> getStudents() {
		
		logger.info("in getStudents(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Student>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Student>>() {});

		// get the list of students from response
		List<Student> students = responseEntity.getBody();

		logger.info("in getStudents(): students" + students);
		
		return students;
	}

	@Override
	public Student getStudent(int theId) {

		logger.info("in getStudent(): Calling REST API " + crmRestUrl);

		// make REST call
		Student theStudent = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
										  Student.class);

		logger.info("in saveStudent(): theStudent=" + theStudent);
		
		return theStudent;
	}

	@Override
	public void saveStudent(Student theStudent) {

		logger.info("in saveStudent(): Calling REST API " + crmRestUrl);
		
		int employeeId = theStudent.getId();

		// make REST call
		if (employeeId == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, theStudent, String.class);			
		
		} else {
			// update employee
			restTemplate.put(crmRestUrl, theStudent);
		}

		logger.info("in saveStudent(): success");	
	}

	@Override
	public void deleteStudent(int theId) {

		logger.info("in deleteStudent(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteStudent(): deleted student theId=" + theId);
	}

	@Override
	public List<Course> getStudentCourses(int studentId) {
		
		logger.info("in getStudentCourses(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Course>> responseEntity = 
											restTemplate.exchange(crmRestUrl +"/courses/" + studentId, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Course>>() {});

		// get the list of courses from response
		List<Course> courses = responseEntity.getBody();

		logger.info("in getStudentCourses(): courses" + courses);
		
		return courses;
	}

	@Override
	public void deleteStudentCourse(int courseId, int studentId) {
		
		logger.info("in deleteStudentCourse(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/courses/" + courseId + "/" + studentId);

		logger.info("in deleteStudentCourse(): deleted course theId=" + courseId);
		
		
	}

	@Override
	public List<Course> listAddStudentCourse(int studentId) {
		
		logger.info("in listAddStudentCourse(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Course>> responseEntity = 
											restTemplate.exchange(crmRestUrl + "/courses/add/" + studentId, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Course>>() {});

		// get the list of students from response
		List<Course> courses = responseEntity.getBody();

		logger.info("in listAddStudentCourses(): courses" + courses);
		
		return courses;
	}

	@Override
	public void addStudentCourse(int courseId, int studentId) {
		
		logger.info("in addStudentCourse(): Calling REST API " + crmRestUrl);
		
		
		restTemplate.postForEntity(crmRestUrl + "/courses/add/" + courseId + "/" + studentId, null, null);			
		

		logger.info("in addStudentCourse(): success");	
		
	}
	
}