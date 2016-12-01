package com.asif.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.asif.model.Course;
import com.asif.model.Offer;
import com.asif.model.Student;

@SpringBootConfiguration
public class BaseConfiguration {
	
	@Bean
	public Student student() {
		return new Student("0205031", "Asif Iqbal");
	}
	
	@Bean
	public Course course() {
		return new Course("CSE101", "Structured Programming Language");
	}
	
	@Bean
	public Offer offer() {
		return new Offer();
	}
}
