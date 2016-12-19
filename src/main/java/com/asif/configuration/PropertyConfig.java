package com.asif.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.asif.model.Student;

@Component
@ConfigurationProperties(prefix="app")
public class PropertyConfig {
	private String org;
	private int year;
	private String dept;
	private String faculty;
	private List<Student> students;
	
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		System.out.println("Asif Iqbal " + org);
		this.org = org;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		System.out.println("Asif Iqbal " + year);
		this.year = year;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
