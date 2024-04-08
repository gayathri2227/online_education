package com.attendance.service;

import java.util.List;

import com.attendance.entity.Attendance;

public interface AttendanceService {
	
	public Attendance saveDetail(Attendance attendance);
	public List<String> getStatus(boolean status);
	
	public Attendance update(Attendance attendance);
	

}
