package com.teacher;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.teacher.controller.TeacherController;
import com.teacher.entity.Teacher;
import com.teacher.service.TeacherServiceImp;

public class TeacherControllerTests {

    @Mock
    private TeacherServiceImp teacherServiceImp;

    @InjectMocks
    private TeacherController teacherController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        Teacher teacher = new Teacher();
        when(teacherServiceImp.saveDetails(teacher)).thenReturn(teacher);

        Teacher savedTeacher = teacherController.save(teacher);
        assertNotNull(savedTeacher);
        // Add more assertions as needed
    }

    @Test
    public void testSearchByTeacher() {
        long id = 1;
        Teacher teacher = new Teacher();
        when(teacherServiceImp.searchByTeacher(id)).thenReturn(teacher);

        Teacher foundTeacher = teacherController.searchByTeacher(id);
        assertNotNull(foundTeacher);
        // Add more assertions as needed
    }

    @Test
    public void testUpdate() {
        Teacher teacher = new Teacher();
        when(teacherServiceImp.update(teacher)).thenReturn(teacher);

        Teacher updatedTeacher = teacherController.update(teacher);
        assertNotNull(updatedTeacher);
        // Add more assertions as needed
    }

    @Test
    public void testDelete() {
        long id = 1;
        String deletionMessage = "Deleted successfully";
        when(teacherServiceImp.delete(id)).thenReturn(deletionMessage);

        String resultMessage = teacherController.delete(id);
        assertEquals(deletionMessage, resultMessage);
    }

    @Test
    public void testGetAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        when(teacherServiceImp.getAllTeacherDetails()).thenReturn(teachers);

        List<Teacher> allTeachers = teacherController.getAllTeachers();
        assertNotNull(allTeachers);
        // Add more assertions as needed
    }
}
