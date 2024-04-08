package com.course.service;

import java.util.List;

import com.course.entity.Course;

public interface CourseService {
	
	public Course saveDetails(Course course);
	
	public List<Course> getAllCourse();
	
	public Course searchByName(String name);
	
	public Course searchById(long id);
	
	public String delete(Course course);
	
	public Course update(Course course);
	

}
