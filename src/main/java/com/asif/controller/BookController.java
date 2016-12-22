package com.asif.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asif.model.Book;
import com.asif.service.BookService;
import com.asif.validation.BookValidator;

@RestController
@RequestMapping("/books")
public class BookController {
	
    @Autowired
    private BookService service;
    
    @Autowired
	private BookValidator bookValidator;
    
    @InitBinder
    public void dataBinding(WebDataBinder binder) {
    	binder.addValidators(bookValidator);
    } 
    
    @RequestMapping(value = "/{id}", 
                    method = RequestMethod.GET, 
                    produces={MediaType.APPLICATION_JSON_VALUE})
    public Book getBook(@PathVariable Long id, HttpServletRequest rew) {
        return service.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public void getBook3() {
        
    }
    
    @RequestMapping(value = "/create", 
                    method = RequestMethod.POST, 
                    consumes={MediaType.APPLICATION_JSON_VALUE})
    public String createBook(@RequestBody @Valid Book book) {
//    	if(result.hasErrors()) {
//	    	return result.getAllErrors().get(0).toString();
//	    }
        service.createBook(book);
        return "success";
    }
    
    @RequestMapping(value = "/update/{id}", 
                    method = RequestMethod.PUT, 
                    consumes={MediaType.APPLICATION_JSON_VALUE})
    public void updateBook(@RequestBody Book book, @PathVariable Long id) {
        service.updateBook(book, id);       
    }

    @RequestMapping(method = RequestMethod.GET, 
                    produces={MediaType.APPLICATION_JSON_VALUE})
    public List<Book> getBooks() {
        return service.findAll();
    }
}
