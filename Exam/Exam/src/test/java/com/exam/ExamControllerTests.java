package com.exam;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.exam.controller.ExamController;
import com.exam.dto.TestAnswerSubmit;
import com.exam.entity.Exam;
import com.exam.service.ExamServiceImp;

public class ExamControllerTests {

    @Mock
    private ExamServiceImp examServiceImp;

    @InjectMocks
    private ExamController examController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllExams() {
        List<Exam> exams = List.of(new Exam(), new Exam());
        when(examServiceImp.getAllExams()).thenReturn(exams);

        List<Exam> result = examController.findAllExams();
        assertEquals(exams, result);
    }

    @Test
    public void testSave() {
        Exam exam = new Exam();
        when(examServiceImp.saveDetails(exam)).thenReturn(exam);

        Exam savedExam = examController.save(exam);
        assertEquals(exam, savedExam);
    }

    @Test
    public void testUpdate() {
        Exam exam = new Exam();
        when(examServiceImp.update(exam)).thenReturn(exam);

        Exam updatedExam = examController.update(exam);
        assertEquals(exam, updatedExam);
    }

    @Test
    public void testSearchByExamId() {
        long id = 1;
        Exam exam = new Exam();
        when(examServiceImp.searchByExamID(id)).thenReturn(exam);

        Exam foundExam = examController.searchByExamId(id);
        assertEquals(exam, foundExam);
    }

    @Test
    public void testTakeExam() {
        long examId = 1;
        Set<String> questions = new HashSet<>();
        questions.add("Question 1");
        questions.add("Question 2");
        when(examServiceImp.takeExam(examId)).thenReturn(questions);

        Set<String> result = examController.takeExam(examId);
        assertEquals(questions, result);
    }

    @Test
    public void testSubmitAnswer() {
        long studentId = 1;
        long examId = 1;
        List<TestAnswerSubmit> answers = List.of(new TestAnswerSubmit(), new TestAnswerSubmit());
        int score = 80;
        when(examServiceImp.submitAnswer(studentId, examId, answers)).thenReturn(score);

        int result = examController.submitAnswer(studentId, examId, answers);
        assertEquals(score, result);
    }
}
