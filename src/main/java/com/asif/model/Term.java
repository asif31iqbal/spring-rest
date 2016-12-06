package com.asif.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Term implements Model {
	private String id;
	private String name;
	private List<Course> courses;
	
	public Term() {
		super();
	}
	public Term(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		String s =  "ID = " + id + ", Name = " + name;
		s += "\n\r Courses:";
		for(Course c : courses) {
			s += "\n\r\t " + c;
		}
		return s;
	}
}
