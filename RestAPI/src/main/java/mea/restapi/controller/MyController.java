package mea.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mea.restapi.model.Course;
import mea.restapi.service.CourseService;
@RestController
public class MyController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String Home() {
		
		return "this is home page";
	}
	
	//get the courses
	@GetMapping("/course")
	public List<Course> getCourse()
	{
	
		return this.courseService.getCourse() ;
		
	}
	
	//Single course get
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	//course add
	
	//@PostMapping(path="/course",consumes="application/json")
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseService.addCourse(course);
	}
}
