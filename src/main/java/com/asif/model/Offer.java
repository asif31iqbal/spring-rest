package com.asif.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Offer {
	
	public Offer() {
		super();
	}

	public Offer(Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
	}

	private Student student;
	private Course course;
	
	public Student getStudent() {
		return student;
	}
	
	@Autowired
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Course getCourse() {
		return course;
	}
	
	@Autowired
	public void setCourse(Course course) {
		this.course = course;
	}

	
	
}
