package mea.restapi.service;

import java.util.List;

import mea.restapi.model.Course;

public interface CourseService {
	
	public List<Course> getCourse();
	
	//
	//public Course get
	public Course getCourse(long courseId);
	
	//post
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long parseLong);
	

}
