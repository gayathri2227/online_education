package com.comment.dao;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.comment.dto.CourseDto;



@FeignClient(name="COURSE")
public interface CourseDao {
	
	@LoadBalanced
	@GetMapping("course/get/{id}")
	public CourseDto searchByCourseId(@PathVariable("id") long id);

}
