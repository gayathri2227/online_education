package com.exam.service;

import java.util.List;

import com.exam.entity.Exam;
import com.exam.entity.TestPaper;

public interface ExamService {
	
	public Exam saveDetails(Exam exam);
	
	public Exam update(Exam exam);
	
	public void delete(Exam exam);
	
	public List<Exam>  getAllExams();

	//int submitAnswer(long examId, List<TestPaper> answers);

	//int submitAnswer(long studentId, long emamId, List<String> answers);

}
