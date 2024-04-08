package com.comment.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.comment.dto.StudentDto;


@FeignClient(name="STUDENT")
public interface StudentDao {
	
	@GetMapping("student/{id}")
	public StudentDto SearchByStudent(@PathVariable("id") long id);

}
