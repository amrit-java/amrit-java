package mea.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mea.restapi.model.Course;

public interface CourseDao extends JpaRepository<Course, Long> {
	

}
