package com.student.dao;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.student.dto.CourseDto;


@FeignClient(name="COURSE")
public interface CourseDao {
	@LoadBalanced
	@GetMapping("course/get/{id}")
	public CourseDto searchByCourseId(@PathVariable("id") long id);
	
	
	@PutMapping("course/update")
	public CourseDto update(@RequestBody CourseDto course);
	

}
