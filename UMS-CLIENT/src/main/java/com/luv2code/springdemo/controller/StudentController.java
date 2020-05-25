package com.luv2code.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.model.Course;
import com.luv2code.springdemo.model.Student;
import com.luv2code.springdemo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public String listStudents(Model theModel)
	{
		List<Student> students = studentService.getStudents();
		
		theModel.addAttribute("students",students);
		
		return "list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Student student = new Student();
		
		theModel.addAttribute("student",student);
		
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent,
								BindingResult theBindingResult)
	{
		if(theBindingResult.hasErrors())
		{
			return "student-form";
		}
		else {
		studentService.saveStudent(theStudent);
		
		return "redirect:/student/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel)
	{
		//Get the student from the service
		Student theStudent = studentService.getStudent(theId);
		
		//add student to the model
		theModel.addAttribute("student", theStudent);
		
		//send over to our form
		return "student-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int id)
	{
		studentService.deleteStudent(id);
		
		return "redirect:/student/list";
	}
	
	@GetMapping("/courses")
	public String listStudentCourses(@RequestParam("studentId") int studentId, Model theModel)
	{
				
		List<Course> studentCourses = studentService.getStudentCourses(studentId);
		Student student = studentService.getStudent(studentId);
		
		theModel.addAttribute("studentCourses", studentCourses);
		theModel.addAttribute("studentId", studentId);
		theModel.addAttribute("student", student);
		
		System.out.println("Student ID = " + studentId);
		
		return "list-student-courses";
	}
	
	@GetMapping("/deleteStudentCourse")
	public String deleteStudentCourse(@RequestParam("courseId") int courseId, @RequestParam("studentId") int studentId)
	{
		studentService.deleteStudentCourse(courseId, studentId);
		
		return "redirect:/student/list";
		
	}
	
	@GetMapping("/listAddStudentCourses")
	public String listAddStudentCourses(@RequestParam("studentId") int studentId, Model theModel)
	{
		System.out.println("Inside listAddStudentCourses");
		
		List<Course> courses = studentService.listAddStudentCourse(studentId);
		Student student = studentService.getStudent(studentId);
		
		theModel.addAttribute("addStudentCourses",courses);
		theModel.addAttribute("studentId",studentId);
		theModel.addAttribute("student", student);
		
		return "list-add-student-courses";
	}
	
	@GetMapping("/addStudentCourses")
	public String addStudentCourses(@RequestParam("courseId") int courseId, @RequestParam("studentId") int studentId)
	{
		studentService.addStudentCourse(courseId, studentId);
		
		return "redirect:/student/list";
	}

}