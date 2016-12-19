package com.asif.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import com.asif.model.Course;
import com.asif.model.Enrollment;
import com.asif.model.Offer;
import com.asif.model.Student;
import com.asif.model.Term;

@SpringBootConfiguration
//@Import(PropertyConfig.class)
//@EnableConfigurationProperties(PropertyConfig.class)
public class BaseConfiguration {
	
	private PropertyConfig propertyConfig;
	private Demographic demographicConfig;
	private UserConfig userConfig;
	
	private DataSourceTransactionManager transactionManager;
	
	@Autowired
	public void setDataSourceOnTransactionManager(DataSource dataSource) {
		transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
	}
	
	@Bean
	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}
	
	@Autowired
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public UserConfig getUserConfig() {
		return userConfig;
	}

	@Autowired
	public void setUserConfig(UserConfig userConfig) {
		this.userConfig = userConfig;
	}

	public Demographic getDemographicConfig() {
		return demographicConfig;
	}

	@Autowired
	public void setDemographicConfig(Demographic demographicConfig) {
		this.demographicConfig = demographicConfig;
	}

	public PropertyConfig getPropertyConfig() {
		return propertyConfig;
	}

	@Autowired
	public void setPropertyConfig(PropertyConfig propertyConfig) {
		this.propertyConfig = propertyConfig;
	}
	
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
	
//	@Bean
//	public Enrollment enrollment(){
//		return new Enrollment();
//	}
}
