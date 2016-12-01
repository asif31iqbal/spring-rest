package com.asif.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="book")
@XmlRootElement(name="myRootTag")
public class Book {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private String author;
	
	public Book() {
	    
	}
	
	public Book(String name, String author){
		this.name = name;
		this.author = author;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
        this.id = id;
    }
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
        this.name = name;
    }
	
	public String getAuthor(){
		return author;
	}
	
	public void setAuthor(String author){
        this.author = author;
    }
	
	@Override
	public String toString(){
	    return id + "-" + name + "-" + author;
	}
}
