package com.exam.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.StudentDao;
import com.exam.dto.TestAnswerSubmit;
import com.exam.entity.Exam;
import com.exam.entity.Student;
import com.exam.entity.TestPaper;
import com.exam.repository.ExamRepository;
import com.exam.repository.StudentRepository;
import com.exam.repository.TestPaperRepository;
import com.exam.exception.ResourceNotFoundException;

@Service
public class ExamServiceImp implements ExamService {

	@Autowired
	private StudentDao dao;
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private TestPaperRepository paperRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	int score = 0;

	@Override
	public Exam saveDetails(Exam exam) {

		for (TestPaper paper : exam.getTestPaper()) {
			paperRepository.save(paper);
		}

		return examRepository.save(exam);
	}

	@Override
	public Exam update(Exam exam) {

		if (searchByExamID(exam.getExamId()) == null) {
			throw new ResourceNotFoundException("Exam not found for Id");

		}
		return examRepository.save(exam);
	}

	@Override
	public void delete(Exam exam) {
		if (searchByExamID(exam.getExamId()) == null) {
			throw new ResourceNotFoundException("exam not found for Id");

		}
		examRepository.delete(exam);
	}

	public Exam searchByExamID(long id) {
		if (examRepository.findByExamId(id).get() == null) {
			throw new ResourceNotFoundException("exam not found for Id");

		}
		return examRepository.findByExamId(id).get();
	}

	public Set<String> takeExam(Long examId) {
		Set<String> questionsAndChoices = new HashSet<>();

		Exam exam = examRepository.findByExamId(examId).get();
		if (exam != null) {
			List<TestPaper> testPapers = exam.getTestPaper();
			if (testPapers != null) {
				for (TestPaper testPaper : testPapers) {
					String question = testPaper.getQuestion();
					String choice1 = testPaper.getChoice1();
					String choice2 = testPaper.getChoice2();
					String choice3 = testPaper.getChoice3();
					String choice4 = testPaper.getChoice4();

					String questionWithChoices = "Question: " + question + "\n" + "1. " + choice1 + "\n" + "2. "
							+ choice2 + "\n" + "3. " + choice3 + "\n" + "4. " + choice4 + "\n";

					questionsAndChoices.add(questionWithChoices);
				}
			}
		}

		return questionsAndChoices;
	}

	public int submitAnswer(long studentId, long emamId, List<TestAnswerSubmit> answers) {

//		if (dao.SearchByStudent(emamId) == null) {
//			return -1;
//		}

//		if (examRepository.findByExamId(emamId).get() == null) {
//			return -1;
//		}
//
//		Exam exam = examRepository.findByExamId(emamId).get();
		score = 0;
		
		Map<Long, String> testIdToCorrectAnswerMap = answers.stream().collect(
				Collectors.toMap(answer -> answer.getTestId(), answer -> getCorrectAnswer(answer.getTestId())));

		System.out.println(testIdToCorrectAnswerMap);
		answers.stream().map(answer -> {

			if (testIdToCorrectAnswerMap.containsKey(answer.getTestId())) {
				boolean result = testIdToCorrectAnswerMap.get(answer.getTestId()).equals(answer.getAnswer());
				if (result) {
					score++;
				}
			}

			return answer;
		}).forEach(System.out::println);

		System.out.println(score);
		Student student = studentRepository.findByStudentId(studentId).get();
		student.setScore(score);
		studentRepository.save(student);
//		dao.SearchByStudent(studentId).setScore(score);
//		dao.update(dao.SearchByStudent(studentId));
		return score;
	}

	public String getCorrectAnswer(long testId) {
 
		System.out.println("Test Id"+testId);
		String correctAnswer = paperRepository.findById(testId).get().getActualAnswer();
		 System.out.println(correctAnswer);
		return correctAnswer;
	}

	@Override
	public List<Exam> getAllExams() {
		return examRepository.findAll();
	}

	public int submitAnswer(Long studentId, long examId, List<TestPaper> answers) {
		int c = 0;

		if (dao.SearchByStudent(studentId) == null) {
			return -1;
		}
		for (int i = 0; i < answers.size(); i++) {
			if (paperRepository.findByQuestion(answers.get(i).getQuestion()) == null) {

			}
			if (answers.get(i).getActualAnswer().equals(answers.get(i).getAnswer())) {
				c = c + 1;
			}
		}
		dao.SearchByStudent(studentId).setScore(c);
		dao.update(dao.SearchByStudent(studentId));

		return c;
	}

	public int marks(TestPaper testpaper) {

		int c = 0;
		if (paperRepository.findById(testpaper.getTestId()).get() == null) {

		}

		if (testpaper.getActualAnswer().equals(testpaper.getAnswer())) {
			c = c + 1;
		}

		return c;

	}

	public TestPaper update(TestPaper testPaper) {
		return paperRepository.saveAndFlush(testPaper);
	}

}
