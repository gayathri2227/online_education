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
    void testSaveDetails() {
        Student student = new Student();
        when(serviceImp.saveDetails(student)).thenReturn(student);

        Student savedStudent = studentController.saveDetails(student);
        assertNotNull(savedStudent);
        // Add more assertions as needed
    }

    @Test
    void testUpdate() {
        Student student = new Student();
        when(serviceImp.update(student)).thenReturn(student);

        Student updatedStudent = studentController.update(student);
        assertNotNull(updatedStudent);
        // Add more assertions as needed
    }

    @Test
    void testSearchByStudent() {
        long id = 1;
        Student student = new Student();
        when(serviceImp.searchById(id)).thenReturn(student);

        Student foundStudent = studentController.searchByStudent(id);
        assertNotNull(foundStudent);
        // Add more assertions as needed
    }

    @Test
    void testDeleteStudent() {
        long id = 1;
        String deletionMessage = "Deleted successfully";
        when(serviceImp.delete(id)).thenReturn(deletionMessage);

        String resultMessage = studentController.deleteStudent(id);
        assertEquals(deletionMessage, resultMessage);
    }

    @Test
     void testGetAll() {
        List<Student> students = new ArrayList<>();
        when(serviceImp.getAll()).thenReturn(students);

        List<Student> allStudents = studentController.getAll();
        assertNotNull(allStudents);
        // Add more assertions as needed
    }

    @Test
    void testGetAllPass() {
        List<Student> students = new ArrayList<>();
        when(serviceImp.getAllPass()).thenReturn(students);

        List<Student> passedStudents = studentController.getAllPass();
        assertNotNull(passedStudents);
        // Add more assertions as needed
    }

    @Test
    void testGetAllFail() {
        List<Student> students = new ArrayList<>();
        when(serviceImp.getAllFail()).thenReturn(students);

        List<Student> failedStudents = studentController.getAllFail();
        assertNotNull(failedStudents);
        // Add more assertions as needed
    }

    @Test
     void testGetScore() {
        long id = 1;
        int score = 90;
        when(serviceImp.getScore(id)).thenReturn(score);

        int resultScore = studentController.getScore(id);
        assertEquals(score, resultScore);
    }

    @Test
    void testRegisterForCourse() {
        long studentId = 1;
        long courseId = 1;
        String registrationMessage = "Registered successfully";
        when(serviceImp.registerForCourse(studentId, courseId)).thenReturn(registrationMessage);

        String resultMessage = studentController.registerForCourse(studentId, courseId);
        assertEquals(registrationMessage, resultMessage);
    }
    
    @Test
    void testParameterizedConstructor() {
        // Create a sample student object using the parameterized constructor
        Student student = new Student(1, "John", "Doe", "2000-01-01", "1234567890",
                "password", "john.doe@example.com", List.of(1, 2), 101, 90, "123 Main St");

        // Check if the values are set correctly
        assertEquals(1, student.getStudentId());
        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals("2000-01-01", student.getDateOfBrith());
        assertEquals("1234567890", student.getContactNum());
        assertEquals("password", student.getPassword());
        assertEquals("john.doe@example.com", student.getEmail());
        assertEquals(List.of(1, 2), student.getAttendances());
        assertEquals(101, student.getCourseId());
        assertEquals(90, student.getScore());
        assertEquals("123 Main St", student.getAddress());
    }
    @Test
    void testToString() {
        // Create a sample student object
        Student student = new Student();
        student.setStudentId(1);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setDateOfBrith("2000-01-01");
        student.setContactNum("1234567890");
        student.setEmail("john.doe@example.com");
        student.setAddress("123 Main St");
        student.setPassword("password");
        student.setScore(90);

        // Define the expected string representation
        String expectedToString = "Student [studentId=1, firstName=John, lastName=Doe, dateOfBrith=2000-01-01, " +
                "contactNum=1234567890, password=password, email=john.doe@example.com, attendances=null, " +
                "courseId=0, score=90, address=123 Main St]";

        // Check if the toString method produces the expected output
        assertEquals(expectedToString, student.toString());
    }
}


