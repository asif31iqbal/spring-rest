package com.asif.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.asif.model.Course;
import com.asif.model.Enrollment;
import com.asif.model.Offer;
import com.asif.model.Student;
import com.asif.model.Term;

@SpringBootConfiguration
public class BaseConfiguration {
	
	@Bean
	public Student student() {
		return new Student("0205031", "Asif Iqbal");
	}
	
	@Bean(name = "Course")
//	@Primary
	public Course course1() {
		return new Course("CSE101", "Structured Programming Language");
	}
	
//	@Bean
//	public Course course2() {
//		return new Course("CSE102", "Logic and Discrete Mathematics");
//	}
	
	@Bean
	public Offer offer() {
		return new Offer();
	}
	
	@Bean
	public Term term11() {
		Term t = new Term("1-1", "Level 1 term 1");
		List<Course> courses = new ArrayList<Course>();
		courses.add(course1());
//		courses.add(course2());
		t.setCourses(courses);
		
		return t;
	}
	
	@Bean
	public Enrollment enrollment(){
		return new Enrollment();
	}
}
