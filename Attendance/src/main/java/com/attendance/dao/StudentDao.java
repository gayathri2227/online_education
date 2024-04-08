package com.attendance.dao;

import java.util.List;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.attendance.dto.StudentDto;



@FeignClient(name="STUDENT")
public interface StudentDao {
     
	@LoadBalanced
	@GetMapping("student/{id}")
	public StudentDto SearchByStudent(@PathVariable("id") long id);
	
	 @GetMapping("student/all")
	    public List<StudentDto> getAll();
	
}
