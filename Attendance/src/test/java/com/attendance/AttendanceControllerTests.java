package com.attendance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.attendance.controller.AttendanceController;
import com.attendance.entity.Attendance;
import com.attendance.service.AttendanceServiceImp;

public class AttendanceControllerTests {

    @Mock
    private AttendanceServiceImp attendanceServiceImp;

    @InjectMocks
    private AttendanceController attendanceController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveDetails() {
        int studentId = 123;
        Attendance attendance = new Attendance();
        when(attendanceServiceImp.saveDetail(any(Attendance.class))).thenReturn(attendance);

        Attendance savedAttendance = attendanceController.saveDetails(studentId);
        assertEquals(attendance, savedAttendance);
    }

    @Test
    public void testUpdate() {
        Attendance attendance = new Attendance();
        when(attendanceServiceImp.update(any(Attendance.class))).thenReturn(attendance);

        Attendance updatedAttendance = attendanceController.update(attendance);
        assertEquals(attendance, updatedAttendance);
    }

    @Test
    public void testGetStatus() {
        List<String> statusList = List.of("Present", "Absent");
        when(attendanceServiceImp.getStatus(true)).thenReturn(statusList);

        List<String> result = attendanceController.getStatus();
        assertEquals(statusList, result);
    }
}
