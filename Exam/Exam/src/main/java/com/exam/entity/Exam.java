package com.exam.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "exams")
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long examId;
	
	private String testName;
	
	private int duration;
	
	private String testTime;
	
	private int noOfQues;
	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="examId")
	private List<TestPaper> testPaper;

//	private List<String> correctAnswer;

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTestTime() {
		return testTime;
	}

	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}

	public int getNoOfQues() {
		return noOfQues;
	}

	public void setNoOfQues(int noOfQues) {
		this.noOfQues = noOfQues;
	}

	public List<TestPaper> getTestPaper() {
		return testPaper;
	}

	public void setTestPaper(List<TestPaper> testPaper) {
		this.testPaper = testPaper;
	}

//	public List<String> getCorrectAnswers() {
//		// TODO Auto-generated method stub
//		return correctAnswer;
//	}
//	
	
	
	
	
	

}
