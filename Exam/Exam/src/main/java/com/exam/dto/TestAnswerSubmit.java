package com.exam.dto;


public class TestAnswerSubmit {
	
	private long testId;
	
	private String answer;

	public TestAnswerSubmit(long testId, String answer) {
		super();
		this.testId = testId;
		this.answer = answer;
	}

	public TestAnswerSubmit() {
		super();
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "TestAnswerSubmit [testId=" + testId + ", answer=" + answer + "]";
	}
	
	
	
	

}
