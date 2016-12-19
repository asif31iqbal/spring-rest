package com.asif.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.asif.configuration.PropertyConfig;

@Component
public class Enrollment implements Model {
	private Model student;
	private Model course;
	
	private PropertyConfig pc;

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
		
	public PropertyConfig getPc() {
		return pc;
	}

	@Autowired
	public void setPc(PropertyConfig pc) {
		this.pc = pc;
	}

	@Override
	public String toString() {
		//return (Student)student + " " + (Course)course + pc.getOrg();
		return  "gheu "+ pc.getOrg();
	}
}
