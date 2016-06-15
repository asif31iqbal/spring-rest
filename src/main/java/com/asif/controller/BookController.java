package com.asif.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asif.model.Book;
import com.asif.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	//private final AtomicLong counter = new AtomicLong();
	
	//Map<Long, Book> map = new HashMap<Long, Book>();
	
	@Autowired
	private BookService service;
	
//	@RequestMapping(value = "/book", method = RequestMethod.GET)
//	public Book getBook(@RequestParam(value="name", defaultValue="Test Book") String name) {
//		for(Entry<Long, Book> entry : map.entrySet()){
//		    if(entry.getValue().getName().equals(name)){
//		        return entry.getValue();
//		    }
//		}
//		
//		return null;
//	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        //return map.get(id);
	    return service.findById(id);
    }
	
//	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
//	public Book getBook2(@PathVariable String name) {
//		return new Book(counter.incrementAndGet(), name, "Test Author");
//	}
//	
	@RequestMapping(method = RequestMethod.GET)
    public void getBook3() {
        
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    public void createBook(@RequestBody Book book) {
        //long id = counter.incrementAndGet();
        //map.put(id, new Book(id, "Default name", "Default Author"));
        service.createBook(book);
        
    }
	
//	@RequestMapping(method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
//    public List<Book> getBooks() {
//        return new ArrayList<Book>(map.values());
//    }
}
