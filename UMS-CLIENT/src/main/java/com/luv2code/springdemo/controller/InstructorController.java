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
import com.luv2code.springdemo.model.Instructor;
import com.luv2code.springdemo.service.InstructorService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/list")
	public String listInstructors(Model theModel)
	{
		List<Instructor> instructors = instructorService.getInstructors();
		
		theModel.addAttribute("instructors",instructors);
		
		return "list-instructors";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Instructor instructor = new Instructor();
		
		theModel.addAttribute("instructor",instructor);
		
		return "instructor-form";
	}
	
	@PostMapping("/saveInstructor")
	public String saveInstructor(@Valid @ModelAttribute("instructor") Instructor theInstructor,
								BindingResult theBindingResult)
	{
		if(theBindingResult.hasErrors())
		{
			return "instructor-form";
		}
		else {
		instructorService.saveInstructor(theInstructor);
		
		return "redirect:/instructor/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("instructorId") int theId, Model theModel)
	{
		//Get the instructor from the service
		Instructor theInstructor = instructorService.getInstructor(theId);
		
		//add instructor to the model
		theModel.addAttribute("instructor", theInstructor);
		
		//send over to our form
		return "instructor-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("instructorId") int id)
	{
		instructorService.deleteInstructor(id);
		
		return "redirect:/instructor/list";
	}
	
	@GetMapping("/courses")
	public String listInstructorCourses(@RequestParam("instructorId") int instructorId, Model theModel)
	{
				
		List<Course> instructorCourses = instructorService.getInstructorCourses(instructorId);
		Instructor instructor = instructorService.getInstructor(instructorId);
			
		theModel.addAttribute("instructorCourses", instructorCourses);
		theModel.addAttribute("instructorId", instructorId);
		theModel.addAttribute("instructor", instructor);
		
		System.out.println("Instructor ID = " + instructorId);
		
		return "list-instructor-courses";
	}
	
	@GetMapping("/deleteInstructorCourse")
	public String deleteInstructorCourse(@RequestParam("courseId") int courseId, @RequestParam("instructorId") int instructorId)
	{
		instructorService.deleteInstructorCourse(courseId);
		
		return "redirect:/instructor/list";
		
	}
	
	@GetMapping("/listAddInstructorCourses")
	public String listAddInstructorCourses(@RequestParam("instructorId") int instructorId, Model theModel)
	{
		System.out.println("Inside listAddInstructorCourses");
		
		List<Course> courses = instructorService.listAddInstructorCourse();
		Instructor instructor = instructorService.getInstructor(instructorId);
		
		theModel.addAttribute("addInstructorCourses",courses);
		theModel.addAttribute("instructorId",instructorId);
		theModel.addAttribute("instructor",instructor);
		
		return "list-add-instructor-courses";
	}
	
	@GetMapping("/addInstructorCourses")
	public String addInstructorCourses(@RequestParam("courseId") int courseId, @RequestParam("instructorId") int instructorId)
	{
		instructorService.addInstructorCourse(courseId, instructorId);
		
		return "redirect:/instructor/list";
	}

}