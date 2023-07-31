package mea.restapi.service;

import java.util.*;

import org.springframework.stereotype.Service;

import mea.restapi.model.Course;
@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	//create constractor
	 public CourseServiceImpl() {
		 list=new ArrayList<>();//list ka boject bana liya
		 list.add(new Course(145,"core java","this is basic java"));
		 list.add(new Course(146,"Spring boot","this is Advance java"));
		
	}

	@Override
	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for(Course course : list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

}
