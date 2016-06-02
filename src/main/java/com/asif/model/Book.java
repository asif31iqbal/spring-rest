package com.asif.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="myRootTag")
public class Book {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	String name;
	String author;
	
	public Book(long id, String name, String author){
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	public long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAuthor(){
		return author;
	}
}
