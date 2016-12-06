package com.asif.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Enrollment implements Model {
	private Model student;
	private Model course;

	public Model getStudent() {
		return student;
	}
	@Autowired
	@Qualifier("student")
	public void setStudent(Model student) {
		this.student = student;
	}
	public Model getCourse() {
		return course;
	}
	@Autowired
	@Qualifier("Course")
	public void setCourse(Model course) {
		this.course = course;
	}
		
	@Override
	public String toString() {
		return (Student)student + " " + (Course)course;
	}
}
