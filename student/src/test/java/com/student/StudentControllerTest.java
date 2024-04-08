package com.student;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.student.controller.StudentController;
import com.student.entity.Student;
import com.student.service.StudentServiceImp;

public class StudentControllerTest {

    @Mock
    private StudentServiceImp serviceImp;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveDetails() {
        Student student = new Student();
        when(serviceImp.saveDetails(student)).thenReturn(student);

        Student savedStudent = studentController.saveDetails(student);
        assertNotNull(savedStudent);
        // Add more assertions as needed
    }

    @Test
    public void testUpdate() {
        Student student = new Student();
        when(serviceImp.update(student)).thenReturn(student);

        Student updatedStudent = studentController.update(student);
        assertNotNull(updatedStudent);
        // Add more assertions as needed
    }

    @Test
    public void testSearchByStudent() {
        long id = 1;
        Student student = new Student();
        when(serviceImp.searchById(id)).thenReturn(student);

        Student foundStudent = studentController.searchByStudent(id);
        assertNotNull(foundStudent);
        // Add more assertions as needed
    }

    @Test
    public void testDeleteStudent() {
        long id = 1;
        String deletionMessage = "Deleted successfully";
        when(serviceImp.delete(id)).thenReturn(deletionMessage);

        String resultMessage = studentController.deleteStudent(id);
        assertEquals(deletionMessage, resultMessage);
    }

    @Test
    public void testGetAll() {
        List<Student> students = new ArrayList<>();
        when(serviceImp.getAll()).thenReturn(students);

        List<Student> allStudents = studentController.getAll();
        assertNotNull(allStudents);
        // Add more assertions as needed
    }

    @Test
    public void testGetAllPass() {
        List<Student> students = new ArrayList<>();
        when(serviceImp.getAllPass()).thenReturn(students);

        List<Student> passedStudents = studentController.getAllPass();
        assertNotNull(passedStudents);
        // Add more assertions as needed
    }

    @Test
    public void testGetAllFail() {
        List<Student> students = new ArrayList<>();
        when(serviceImp.getAllFail()).thenReturn(students);

        List<Student> failedStudents = studentController.getAllFail();
        assertNotNull(failedStudents);
        // Add more assertions as needed
    }

    @Test
    public void testGetScore() {
        long id = 1;
        int score = 90;
        when(serviceImp.getScore(id)).thenReturn(score);

        int resultScore = studentController.getScore(id);
        assertEquals(score, resultScore);
    }

    @Test
    public void testRegisterForCourse() {
        long studentId = 1;
        long courseId = 1;
        String registrationMessage = "Registered successfully";
        when(serviceImp.registerForCourse(studentId, courseId)).thenReturn(registrationMessage);

        String resultMessage = studentController.registerForCourse(studentId, courseId);
        assertEquals(registrationMessage, resultMessage);
    }
}
