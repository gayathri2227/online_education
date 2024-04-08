package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {
	public String delete(long id);
	
	public Student update(Student student);
    
    public Student saveDetails(Student student);
    
    public Student searchById(long id);
    
    public List<Student> getAll();
    
    public String registerForCourse(long studentId, long courseId);
    
    public int getScore(long id);
    
    public List<Student> getAllPass();
    
    public List<Student> getAllFail();
}
