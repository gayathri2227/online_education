package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.TestPaper;

public interface TestPaperRepository extends JpaRepository<TestPaper, Long>{
	
	
	public TestPaper findByQuestion(String ques);
	

}
