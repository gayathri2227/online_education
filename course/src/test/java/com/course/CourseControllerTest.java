package com.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.course.controller.CourseController;
import com.course.dto.ExamDto;
import com.course.entity.Course;
import com.course.service.CourseServiceImp;

public class CourseControllerTest {

    @Mock
    private CourseServiceImp courseServiceImp;

    @InjectMocks
    private CourseController courseController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveDetails() {
        Course course = new Course();
        when(courseServiceImp.saveDetails(course)).thenReturn(course);

        Course savedCourse = courseController.saveDetails(course);
        assertEquals(course, savedCourse);
    }

    @Test
    public void testUpdate() {
        Course course = new Course();
        when(courseServiceImp.update(course)).thenReturn(course);

        Course updatedCourse = courseController.update(course);
        assertEquals(course, updatedCourse);
    }

    @Test
    public void testSearchByCourseId() {
        long id = 1;
        Course course = new Course();
        when(courseServiceImp.searchById(id)).thenReturn(course);

        Course foundCourse = courseController.searchByCourseId(id);
        assertEquals(course, foundCourse);
    }

    @Test
    public void testSearchByName() {
        String name = "Java";
        Course course = new Course();
        when(courseServiceImp.searchByName(name)).thenReturn(course);

        Course foundCourse = courseController.searchByName(name);
        assertEquals(course, foundCourse);
    }

    @Test
    public void testDelete() {
        long id = 1;
        String expectedResult = "Course deleted successfully";
        when(courseServiceImp.deleteCourse(id)).thenReturn(expectedResult);

        String result = courseController.delete(id);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetExamCourseId() {
        long courseId = 1;
        ExamDto examDto = new ExamDto();
        when(courseServiceImp.getExamDetails(courseId)).thenReturn(examDto);

        ExamDto result = courseController.getExamCourseId(courseId);
        assertEquals(examDto, result);
    }

    @Test
    public void testGetAllCourses() {
        List<Course> courses = List.of(new Course(), new Course());
        when(courseServiceImp.getAllCourse()).thenReturn(courses);

        List<Course> result = courseController.getAllCourses();
        assertEquals(courses, result);
    }

    @Test
    public void testAddExamToTheCourse() {
        long courseId = 1;
        int examId = 1;
        doNothing().when(courseServiceImp).addExamTOTheCourse(courseId, examId);

        courseController.addExamToTheCourse(courseId, examId);

        // Assuming void method call success if no exceptions
    }
}
