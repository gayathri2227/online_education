package com.course.Dao;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.course.dto.ExamDto;


@FeignClient(name="EXAM")
public interface ExamDao {
	
	@GetMapping("exam/get/{id}")
	public ExamDto searchByExamId(@PathVariable("id") long id);

}
