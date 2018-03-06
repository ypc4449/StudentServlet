package com.servlet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="studentId")
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	protected int studentId;
	
	@Column(name="firstname")
	 private String firstname;
	
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="yearLevel")
	private int yearLevel;
	
	@Column(name="marks")
	private long marks;
	
	public Student() {}
	
	public Student(int studentId, String firstname, String lastname, int yearLevel, long marks){
		this.studentId = studentId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.yearLevel = yearLevel;
		this.marks = marks;
	}
	
	
	public Student(int studentId) {
		
		this.studentId = studentId;
	}


	public Student(String firstname, String lastname, int yearLevel, long marks) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.yearLevel = yearLevel;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}
	public long getMarks() {
		return marks;
	}
	public void setMarks(long marks) {
		this.marks = marks;
	}
	
	
}

