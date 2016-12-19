package com.asif.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:demo.properties")
public class UserConfig {
	
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	
	@Value( "${user.name}" )
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	
	@Value( "${user.password}" )
	public void setPassword(String password) {
		this.password = password;
	}
	
}
