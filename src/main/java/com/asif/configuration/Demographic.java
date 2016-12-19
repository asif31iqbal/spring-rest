package com.asif.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="app")
public class Demographic {	
	private String city;
	private String country;
	private int established;
	private List<String> depts;
	private int yearStart;
		
	public int getYearStart() {
		return yearStart;
	}
	public void setYearStart(int yearStart) {
		this.yearStart = yearStart;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getEstablished() {
		return established;
	}
	public void setEstablished(int established) {
		this.established = established;
	}
	public List<String> getDepts() {
		return depts;
	}
	public void setDepts(List<String> depts) {
		this.depts = depts;
	}
	
}
