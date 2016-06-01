package com.asif.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asif.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public Book getBook(@RequestParam(value="name", defaultValue="Test Book") String name,
			@RequestParam(value="author", defaultValue="Test Author") String author) {
		return new Book(counter.incrementAndGet(), name, author);
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Book getBook2(@PathVariable String name) {
		return new Book(counter.incrementAndGet(), name, "Test Author");
	}
}
