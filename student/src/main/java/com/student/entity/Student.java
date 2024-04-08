package com.student.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;
	// Validation annotations for name
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String firstName;
 // Validation annotations for name
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String lastName;
	
	private String dateOfBrith;
	// Validation annotations for contact number using regex pattern
    @Pattern(regexp = "\\d{10}", message = "Contact must be a 10-digit number")
	private String contactNum;
	
	private String password;
	// Validation annotation for email
    @Email(message = "Invalid email format")
	private String email;
	
	private List<Integer> attendances;
	
	private int courseId;
	
	private int score;
	
	

	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Integer> getAttendances() {
		return attendances;
	}


	public void setAttendances(List<Integer> attendances) {
		this.attendances = attendances;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



	private String address;


	public long getStudentId() {
		return studentId;
	}


	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDateOfBrith() {
		return dateOfBrith;
	}


	public void setDateOfBrith(String dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}


	public String getContactNum() {
		return contactNum;
	}


	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}


	public Student(long studentId,
			@NotBlank(message = "Name cannot be blank") @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String firstName,
			@NotBlank(message = "Name cannot be blank") @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String lastName,
			String dateOfBrith,
			@Pattern(regexp = "\\d{10}", message = "Contact must be a 10-digit number") String contactNum,
			String password, String email, List<Integer> attendances, int courseId, int score, String address) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBrith = dateOfBrith;
		this.contactNum = contactNum;
		this.password = password;
		this.email = email;
		this.attendances = attendances;
		this.courseId = courseId;
		this.score = score;
		this.address = address;
	}


	public Student() {
		// TODO Auto-generated constructor stub
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}
	
	

}
