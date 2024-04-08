package com.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.entity.Attendance;
import com.attendance.service.AttendanceServiceImp;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/attendance")
@CrossOrigin(
    allowCredentials = "true",
    allowedHeaders = "*",
    origins = "http://localhost:3000",
    methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
            RequestMethod.OPTIONS, RequestMethod.HEAD },
    maxAge = 3600L,
    exposedHeaders = "Access-Control-Allow-Origin"
)
public class AttendanceController {

    @Autowired
    private AttendanceServiceImp attendanceServiceImp;

    @PostMapping("/saveData/{studentId}")
    public Attendance saveDetails(@PathVariable("studentId") int studentId) {
        Attendance attendance = new Attendance();
        attendance.setStudentId(studentId);
        attendance.setStatus(true);
        return attendanceServiceImp.saveDetail(attendance);
    }

    @PutMapping("/update")
    public Attendance update(@RequestBody Attendance attendance) {
        return attendanceServiceImp.update(attendance);
    }
    
    @GetMapping("/getStaus")
    public List<String> getStatus()
    {
    	return attendanceServiceImp.getStatus(true);
    }
}
